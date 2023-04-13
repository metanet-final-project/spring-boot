package com.example.finalproject.service;

import com.example.finalproject.domain.Booking;
import com.example.finalproject.domain.NonMember;

import java.awt.print.Book;
import java.util.List;

public interface BookingService {
    public int save(Booking booking);
    public List<Booking> findAll();
    public int update(Booking booking);
    public int delete(int id);
    public Booking findByBookingId(int id);
    public List<Booking> findByNonMemberId(NonMember nonMember);
    //public Schedule findAllBySeatId(int scheduled);
    public List<Booking> findSeatByScheduledId(int scheduledId);
}
