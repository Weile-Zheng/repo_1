import time 
from random import *
import threading


class Animal():
    
    def __init__ (self, type, weight):
        self.type = type
        self.weight = weight
    
    def gains(self):
        self.weight += 10

    def tigersound(self):
        print("Wow!") 

    def sheepsound(self):
        print("mie ~")
    
room = []
for i in range (10):
    random = randint(0,1)
    if random == 0:
        object = Animal("Tiger", 200)
    if random == 1:
        object = Animal("Sheep", 100)
    room.append(object)

def play():
    random_room = randint(0,9)
    object = room[random_room]
    x = room[random_room].type
    # print(x)
    print(f'You are currently in room {random_room}')
    action = input("Would you like to feed or knock?: ")
    if action == "feed":
        food = input("Would you like to feed meat or grass?: ")
        if food == "meat" and x == "Tiger":
            object.gains()
            # print(object.weight)
        elif food == "grass" and x == "Sheep":
            object.gains()
            # print(object.weight)
        else:
            object.weight = object.weight

    if action == "knock":
        if x == "Tiger":
            object.tigersound()
        elif x == "Sheep":
            object.sheepsound()


def countdown():
    timer = 0
    while timer < 30:
        time.sleep(1)
        timer += 1 
    quit()

def playloop():
    while True:
        play()

x = threading.Thread(target=countdown, daemon=True)
y = threading.Thread(target=playloop) 

print("game had started!")

x.start()
y.start()

x.join()


print("/n" + "Game has ended!")
print("Room", "Animal", "Weight")
for i in room:
    print(room.index(i), i.type, i.weight)

