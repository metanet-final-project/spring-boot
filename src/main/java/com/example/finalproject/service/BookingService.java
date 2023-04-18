package com.example.finalproject.service;

import com.example.finalproject.domain.Booking;
import com.example.finalproject.domain.Member;
import com.example.finalproject.domain.NonMember;
import com.example.finalproject.dto.BookingDTO;

import java.awt.print.Book;
import java.util.List;

public interface BookingService {
    public int memberSave(Booking booking);
    public List<Booking> findAll();
    public int update(Booking booking);

    public int changeBookingState(Booking booking);
    public int delete(int id);
    public Booking findByBookingId(int id);
    public List<Booking> findByNonMemberId(NonMember nonMember);
    //public Schedule findAllBySeatId(int scheduled);
    public List<Booking> findSeatByScheduledId(int scheduledId);
    public List<Booking> findByPayId(int payId);

    public List<BookingDTO> findAllDTO();
    public List<Booking> findByLoginId(String loginId);
    public List<Booking> findByNonMemId(int nonMemberId);
    public List<Booking> findByNonMemPayId(int nonMemberId, int payId);

    public List<Booking> findValidByLoginId(String loginId);

    public List<Booking> findCancelByLoginId(String loginId);
}
