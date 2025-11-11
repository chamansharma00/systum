from tkinter import *
from tkinter import messagebox

root = Tk()
root.title("Cab Booking")
root.geometry("460x420")
Label(root, text="Book a Cab / Auto", font=("Arial",16)).pack(pady=10)

Label(root, text="Pickup Location").pack(anchor="w", padx=16); Entry(root, width=42).pack(padx=16)
Label(root, text="Drop Location").pack(anchor="w", padx=16, pady=(6,0)); Entry(root, width=42).pack(padx=16)
Label(root, text="Vehicle Type").pack(anchor="w", padx=16, pady=(6,0))
veh=StringVar(value="Auto")
Radiobutton(root, text="Auto", variable=veh, value="Auto").pack(anchor="w", padx=32)
Radiobutton(root, text="Mini Cab", variable=veh, value="Cab").pack(anchor="w", padx=32)

Label(root, text="Preferences").pack(anchor="w", padx=16, pady=(6,0))
ac = IntVar(); luggage = IntVar()
Checkbutton(root, text="AC", variable=ac).pack(anchor="w", padx=32)
Checkbutton(root, text="Extra Luggage", variable=luggage).pack(anchor="w", padx=32)

Label(root, text="Estimated Fare").pack(anchor="w", padx=16, pady=(6,0))
fare = StringVar(value="----"); Label(root, textvariable=fare, font=("Arial",12)).pack(padx=16)

Button(root, text="Get Fare", width=12, command=lambda: fare.set("₹ 150 (dummy)")).pack(side="left", padx=16, pady=12)
Button(root, text="Book Now", width=12, command=lambda: messagebox.showinfo("Booked","Your ride is booked (dummy)")).pack(side="left", padx=8, pady=12)
Button(root, text="Quit", width=12, command=root.destroy).pack(side="right", padx=16, pady=12)

root.mainloop()
