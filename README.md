# Parent-Paging-System-for-Schoolchildren
The aim of this project is to develop a simple client/server application using socket programming. 
# About
This project is dedicated to help parents call their children at the end of each
school day so the children can leave school and go to their parents' car.
Here are the details of each system component:
# Kid’s Phone/Watch (Client 1): 
This device receives a call from the parent’s
phone/computer exit the school’s doors (via a socket by playing a prerecorded sound). In addition, the device should have a button on it so kid can
press it to inform the parent that the child’s school day is over.

# Parent’s Phone/Watch (Client 2): 
This device sends a notification to the
child’s device asking him/her to come to the car. In addition, it receives
notifications from the child’s device letting the parent know that he/she
finished the school day.

# Server:
The server is responsible for connecting Clients 1 and 2.
