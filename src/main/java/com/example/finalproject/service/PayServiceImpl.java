package com.example.finalproject.service;

import com.example.finalproject.annotation.Trace;
import com.example.finalproject.domain.Booking;
import com.example.finalproject.domain.NonMember;
import com.example.finalproject.domain.Pay;
import com.example.finalproject.dto.PayBookingDTO;
import com.example.finalproject.dto.PayBookingNonMemListDTO;
import com.example.finalproject.mapper.BookingMapper;
import com.example.finalproject.mapper.NonMemberMapper;
import com.example.finalproject.mapper.PayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PayServiceImpl implements  PayService{
    @Autowired
    private PayMapper payMapper;

    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private NonMemberMapper nonMemberMapper;

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

    @Transactional
    @Override
    public List<PayBookingDTO> findAll() {
        List<PayBookingDTO> payBookingList = new ArrayList<>();
        List<Pay> payList = payMapper.findAll();
        payList.forEach(pay -> {
            PayBookingDTO  payBookingDTO = new PayBookingDTO();
            payBookingDTO.setId(pay.getId());
            payBookingDTO.setCardExpiration(pay.getCardExpiration());
            payBookingDTO.setCardNumber(pay.getCardNumber());
            payBookingDTO.setCardPassword(pay.getCardPassword());
            payBookingDTO.setBirth(pay.getBirth());
            payBookingDTO.setTotalPrice(pay.getTotalPrice());
            payBookingDTO.setBookingDTOList(bookingMapper.findByPayIdDTO(pay.getId()));
            payBookingList.add(payBookingDTO);
        });
        return payBookingList;
    }

    @Override
    public int updateTotal(int payId, int bookingId) {
        Pay pay = payMapper.getById(payId);

        Booking booking = bookingMapper.findByBookingId(bookingId);
        int priceDifference = -booking.getPrice();

        pay.setTotalPrice(pay.getTotalPrice() + priceDifference);

        return payMapper.updateTotal(pay);


    }
}
