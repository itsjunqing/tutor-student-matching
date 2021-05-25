 # terabytes

FIT3077 student-matching system


## How to run this application

### From the command line

1. install maven
2. mvn compile
3. mvn exec:java -Dexec.mainClass=engine.Driver

### From an IDE

1. Open this in IntelilJ IDEA
2. Go to Preferences -> GUI Designer -> Generate GUI into Java source codes
3. Run Driver class

### User accounts information (updated for Assignment 3)

We have created separate clean test accounts to facilitate the marker in testing functionality.

**For Requirement 1: Monitoring Dashboard**
Note: The bids to be monitored must be manually created by the student accounts below before the tutors can subscribe to them

Username: dummystudent<br>
Password: dummystudent

Username: dummystudent1<br>
Password: dummystudent1

Username: dummytutor<br>
Password: dummytutor

Username: dummytutor1<br>
Password: dummytutor1

**For Requirement 2: Contract length**
Note: The bid and corresponding offers must be created by the student and the tutor, followed by the student accepting the offer before the Contract length can be specified

Username: dummystudent<br>
Password: dummystudent

Username: dummytutor<br>
Password: dummytutor


**For Requirement 2: Student receives expiry notification**
Username: expirystudent<br>
Password: expirystudent

**For Requirement 2: Tutor receives expiry notification**
Username: dummytutor3<br>
Password: dummytutor3

**For Requirement 2: Automatic termination of countract**
Username: almostexpiredstudent<br>
Password: almostexpiredstudent

**For Requirement 2+3: Student renews a contract with same tutor**
Username: renewalstudent<br>
Password: renewalstudent

Username: dummytutor1<br>
Password: dummytutor1

**For Requirement 2+3: Student renews a contract with different tutor**
Username: renewalstudent<br>
Password: renewalstudent

Username: dummytutor<br>
Password: dummytutor

**For Requirement 3: Student can only renew contract with tutor that has the required competency**
Note: dummytutor and dummytutor1 has competency of 10, while dummytutor2 and dummytutor3 has competency of 5.

We provide a script to generate contracts with different competency requirements. If competency of 3 is selected, all dummy tutors (0-3) can be used in renewal, if 4 is provided, then only dummytutor and dummytutor1 can be used in renewal

Username: renewalstudent<br>
Password: renewalstudent

Username: dummytutor<br>
Password: dummytutor

Username: dummytutor1<br>
Password: dummytutor1

Username: dummytutor2<br>
Password: dummytutor2

Username: dummytutor3<br>
Password: dummytutor3

