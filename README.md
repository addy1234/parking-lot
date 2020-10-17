# Parking-Lot
### Thought Process
  For all the given three usecases, we need to have different mappings with us. 
  Mappings used:
  
    1) carMapping: Registration number -> SlotNumber
    
    2) ageMapping: We store all the slots available as per the unique age value.
    
  Using these the three given queries are done in:
  
    1) Slot number in which a car with a given vehicle registration plate is parked -> O(1)
    
    2) Vehicle Registration numbers for all cars which are parked by the driver of a certain age -> O(1)
    
    3) Slot numbers of all slots where cars of drivers of a particular age are parked -> O(1).
    
    These complexities will be O(1) or O(logn) depending upon we are using hashing or a sorted map.
    
### Input
input.txt is the input file given.

### Steps to run
1) Install JDK for your system.
2) Do git clone https://github.com/addy1234/parking-lot.git.
3) cd parking-lot/src
4) Compile using "javac com/aditya/Main.java" 
5) Run using "java com/aditya/Main"

P.S. -> Made one commit after the given time, forgot to add somethings.
