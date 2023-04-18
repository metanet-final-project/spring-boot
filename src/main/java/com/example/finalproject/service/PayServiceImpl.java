package com.example.finalproject.service;

import com.example.finalproject.annotation.Trace;
import com.example.finalproject.domain.Booking;
import com.example.finalproject.domain.NonMember;
import com.example.finalproject.domain.Pay;
import com.example.finalproject.dto.PayBookingListDTO;
import com.example.finalproject.dto.PayBookingNonMemListDTO;
import com.example.finalproject.mapper.BookingMapper;
import com.example.finalproject.mapper.NonMemberMapper;
import com.example.finalproject.mapper.PayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Target;
import java.util.List;

@Service
public class PayServiceImpl implements  PayService{
    @Autowired
    private PayMapper payMapper;

    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private NonMemberMapper nonMemberMapper;

//    @Transactional
//    @Override
//    public int memberInsert(PayBookingListDTO payBookingListDTO) {
//        Pay pay = payBookingListDTO.getPay();
//        List<Booking
//        > bookingList = payBookingListDTO.getBookingList();
//
//        int result = payMapper.insert(pay);
//        bookingList.forEach(booking -> {
//                    booking.setPayId(pay.getId());
//                    bookingMapper.save(booking);
//                }
//        );
//        return result;
//    }


    @Trace
    @Override
    @Transactional
    public int insert(PayBookingNonMemListDTO payBookingNonMemListDTO) {
        Pay pay = payBookingNonMemListDTO.getPay();
        NonMember nonMember = payBookingNonMemListDTO.getNonMember();
        List<Booking> bookingList = payBookingNonMemListDTO.getBookingList();
        System.out.println(pay.toString());
        payMapper.insert(pay);
        System.out.println(pay);
        if(nonMember.getPhone() == null || nonMember.getPhone() == "" || nonMember.getBirth() == null){
            bookingList.forEach(booking -> {
                booking.setPayId(pay.getId());
                System.out.println(booking);
                bookingMapper.memberSave(booking);
            });
        }else {//비회원
            nonMemberMapper.insert(nonMember);
            bookingList.forEach(booking -> {
                booking.setPayId(pay.getId());
                booking.setNonMemberId(nonMember.getId());
                bookingMapper.nonMemberSave(booking);
            });
        }
        return pay.getId();
    }

    @Override
    public Pay getById(int id) {
        return payMapper.getById(id);
    }
}
