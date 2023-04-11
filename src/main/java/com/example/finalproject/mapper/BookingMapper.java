package com.example.finalproject.mapper;

import com.example.finalproject.domain.Booking;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Mapper
public interface BookingMapper {
    public void save(Booking booking);
    public List<Booking> findAll();
    public int update(Booking booking);
    public int delete(int id);
    public int findByBookingId(int id);
    public int findByNonMemberId(NonMember nonMember);
    public Schedule findAllBySeatId(int scheduled);
}
