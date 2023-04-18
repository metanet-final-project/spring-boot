package com.example.finalproject.service;

import com.example.finalproject.domain.Booking;
import com.example.finalproject.domain.NonMember;
import com.example.finalproject.dto.BookingDTO;
import com.example.finalproject.mapper.BookingMapper;
import com.example.finalproject.mapper.NonMemberMapper;
import com.example.finalproject.mapper.PayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private NonMemberMapper nonMemberMapper;

    @Autowired
    private PayService payService;


    @Override
    public int memberSave(Booking booking) {
        return bookingMapper.memberSave(booking);
    }

    @Override
    public List<Booking> findAll() {
        return bookingMapper.findAll();
    }

    @Override
    public int update(Booking booking) {
        return bookingMapper.update(booking);
    }

    @Override
    @Transactional
    public int changeBookingState(Booking booking) {
        int result = bookingMapper.changeBookingState(booking);
        Booking getBooking = bookingMapper.findByBookingId(booking.getId());
        if(payService.updateTotal(getBooking.getPayId(), getBooking.getId()) == 1) {
            return result;
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        return bookingMapper.delete(id);
    }

    @Override
    public Booking findByBookingId(int id) {
        return bookingMapper.findByBookingId(id);
    }


    @Override
    public List<Booking> findByNonMemberId(NonMember nonMember) {
        int id = nonMemberMapper.get(nonMember);
        return bookingMapper.findByNonMemberId(id);
    }

    @Override
    public List<Booking> findSeatByScheduledId(int scheduledId) {
        return bookingMapper.findSeatByScheduledId(scheduledId);
    }

    @Override
    public List<Booking> findByLoginId(String loginId) {
        return bookingMapper.findByLoginId(loginId);
    }


    @Override
    public List<Booking> findValidByLoginId(String loginId) {
        return bookingMapper.findValidByLoginId(loginId);
    }

    @Override
    public List<Booking> findByNonMemId(int nonMemberId) {
        return bookingMapper.findByNonMemId(nonMemberId);
    }

    @Override
    public List<Booking> findByNonMemPayId(int nonMemberId, int payId){
        return bookingMapper.findByNonMemPayId(nonMemberId, payId);
    };

    @Override
    public List<Booking> findCancelByLoginId(String loginId) {
        return bookingMapper.findCancelByLoginId(loginId);
    }

    @Override
    public List<Booking> findByPayId(int payId) {
        return bookingMapper.findByPayId(payId);
    }

    @Override
    public List<BookingDTO> findAllDTO() {
        return bookingMapper.findAllDTO();
    }

    @Override
    public List<BookingDTO> findByPayIdDTO(int payId) {
        return bookingMapper.findByPayIdDTO(payId);
    }
}
