package com.skillstorm.projects.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import com.skillstorm.projects.dtos.ReservationDto;

import java.time.LocalDate;

@Entity
@Table(name = "reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    @NotNull(message = "Guest is required")
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    @NotNull(message = "Room is required")
    private Room room;

    @Column(name = "checkindate", nullable = false)
    @NotNull(message = "Check-in date is required")
    private LocalDate checkInDate;

    @Column(name = "checkoutdate", nullable = false)
    @NotNull(message = "Check-out date is required")
    private LocalDate checkOutDate;

    @Column(name = "numberofguests", nullable = false)
    @Positive(message = "Number of guests must be positive")
    private int numberOfGuests;

    @Column(name = "special_requests", length = 1000)
    private String specialRequests;

    /**
     * Converts the Reservation entity to a ReservationDto object.
     *
     * @return The ReservationDto object.
     */
    public ReservationDto toDto() {
        return new ReservationDto(id, guest, room, checkInDate, checkOutDate, numberOfGuests, specialRequests);
    }
    
    public Reservation(Long id, Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate, int numberOfGuests, String specialRequests) {
        this.id = id;
    	this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfGuests = numberOfGuests;
        this.specialRequests = specialRequests;
    }

    public Reservation(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate, int numberOfGuests, String specialRequests) {
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfGuests = numberOfGuests;
        this.specialRequests = specialRequests;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public String getSpecialRequests() {
		return specialRequests;
	}

	public void setSpecialRequests(String specialRequests) {
		this.specialRequests = specialRequests;
	}
    
    
}
