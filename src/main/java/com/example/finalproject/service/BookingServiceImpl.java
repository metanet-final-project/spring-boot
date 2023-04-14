package com.example.finalproject.service;

import com.example.finalproject.domain.Booking;
import com.example.finalproject.domain.NonMember;
import com.example.finalproject.mapper.BookingMapper;
import com.example.finalproject.mapper.NonMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private NonMemberMapper nonMemberMapper;

    @Override
    public int save(Booking booking) {
        return bookingMapper.save(booking);
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
    public List<Booking> findByPayId(int payId) {
        return bookingMapper.findByPayId(payId);
    }
}
