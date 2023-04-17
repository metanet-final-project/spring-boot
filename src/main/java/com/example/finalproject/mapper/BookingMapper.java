package com.example.finalproject.mapper;

import com.example.finalproject.domain.Booking;
import com.example.finalproject.domain.NonMember;
import com.example.finalproject.dto.BookingDTO;
import com.example.finalproject.dto.ScheduleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BookingMapper {
    public int save(Booking booking);
    public List<Booking> findAll();

    public List<BookingDTO> findAllDTO();
    public int update(Booking booking);

    public int changeBookingState(Booking booking); //예매 상태 변경
    public int delete(int id);
    public Booking findByBookingId(int id);


    public List<Booking> findByNonMemberId(int id);
    //public Schedule findAllBySeatId(int scheduled);
    public List<Booking> findSeatByScheduledId(int scheduleId);
    public List<Booking> findByPayId(int payId);
    public List<Booking> findByLoginId(String loginId);
    public List<Booking> findByNonMemId(int phone);


    public List<Booking> findValidByLoginId(String loginId);

    public List<Booking> findCancelByLoginId(String loginId);
}
