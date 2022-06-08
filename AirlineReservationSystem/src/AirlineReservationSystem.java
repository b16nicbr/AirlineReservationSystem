import java.util.Scanner;

public class AirlineReservationSystem {
	
	private boolean [] seats = new boolean [10];
	Scanner passenger = new Scanner(System.in);
	
	public void Bordingpass(int seat) {
		System.out.println("Bording pass for Airline Reservation System");
		System.out.printf("\nCLASS: %s\nSEAT NUMBER: %d\n\n\n",
                (seat < 5) ? "first" : "economy", seat + 1);
	}
	public boolean setAssingSeats(int Class) {
		if(Class == 1) {
			if(getSeats(Class)>0) {
				for(int i = 0; i<5;i++) {
					if(seats[i] == false) {
						seats[i] = true;
						Bordingpass(i);
						return true;
					}
				}
			}
		}else if (Class == 2) {
			if(getSeats(Class)>0) {
				for(int j= 5; j<seats.length;j++) {
					if(seats[j] == false) {
						seats[j] = true;
						Bordingpass(j);
						return true;
					}
				}
			}
		}
		//if seats are full 
		System.out.println("All seats in section "+ Class + " are booked");
		System.out.printf("Would you like to be moved to class " + Class + " (y/n)? ", (Class == 1)? 1:2);
		if(passenger.next().charAt(0) == 'y') {
			setAssingSeats((Class == 1)? 2:1);
		}else {
			System.out.println("Next flight leaves in 3 hours!");
		}
		return false;
	}
	public int getSeats(int Class) {
		
		int total = 0;
		if(Class == 1) {
			for(int i = 0; i<5;i++) {
				if(seats[i] == false) {
					total += 1;
				}
			}
		}else if(Class == 2) {
			for(int i = 5; i<seats.length;i++) {
				if(seats[i] == false) {
					total += 1;
				}
			}
		}
		return total;
	}
	public boolean availableSeats() {
		for (boolean seat: seats) {
			if(seat == false) {
				return true;
			}
		}
		System.out.println("Airplane is fully booked!");
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please type 1 for First Class and please type 2 for Economy class");
		Scanner number = new Scanner(System.in);
		int num = number.nextInt();
		
		AirlineReservationSystem airline = new AirlineReservationSystem();
		while(airline.availableSeats()) {
			airline.setAssingSeats(num);
		}
					
	}

}
