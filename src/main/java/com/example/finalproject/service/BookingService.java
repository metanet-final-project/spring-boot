package com.example.finalproject.service;

import com.example.finalproject.domain.Booking;

import java.util.List;

public interface BookingService {
    public void save(Booking booking);
    public List<Booking> findAll();
    public int update(Booking booking);
    public int delete(int id);
    public int findByBookingId(int id);
    public int findByNonMemberId(NonMember nonMember);
    public Schedule findAllBySeatId(int scheduled);
}
