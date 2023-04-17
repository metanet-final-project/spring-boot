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

    @Transactional
    @Trace
    @Override
    public int insert(PayBookingNonMemListDTO payBookingNonMemListDTO) {
        Pay pay = payBookingNonMemListDTO.getPay();
        NonMember nonMember = payBookingNonMemListDTO.getNonMember();
        List<Booking> bookingList = payBookingNonMemListDTO.getBookingList();

        int result = payMapper.insert(pay);
        if(nonMember.getPhone() != null){
            int insert = nonMemberMapper.insert(nonMember);
            bookingList.forEach(booking -> {
                booking.setPayId(pay.getId());
                booking.setNonMemberId(nonMember.getId());
                bookingMapper.save(booking);

            });
            return result;
        }else{
            bookingList.forEach(booking -> {
                booking.setPayId(pay.getId());
                bookingMapper.save(booking);
            });
            return result;
        }

    }

    @Override
    public Pay getById(int id) {
        return payMapper.getById(id);
    }
}
