package com.example.finalproject.mapper;

import com.example.finalproject.domain.Booking;
import com.example.finalproject.domain.NonMember;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Mapper
public interface BookingMapper {
    public int save(Booking booking);
    public List<Booking> findAll();
    public int update(Booking booking);
    public int delete(int id);
    public Booking findByBookingId(int id);
    public List<Booking> findByNonMemberId(int id);
    //public Schedule findAllBySeatId(int scheduled);
}
