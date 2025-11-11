from tkinter import *
from tkinter import messagebox

root = Tk()
root.title("Hotel Food Feedback")
root.geometry("460x540")

Label(root, text="Food Feedback Form", font=("Arial", 16)).pack(pady=12)

Label(root, text="Your Name").pack(anchor="w", padx=20)
name = StringVar()
Entry(root, textvariable=name, width=45).pack(padx=20)

Label(root, text="Room / Table No.").pack(anchor="w", padx=20, pady=(8,0))
room = StringVar()
Entry(root, textvariable=room, width=20).pack(padx=20)

Label(root, text="Food Item").pack(anchor="w", padx=20, pady=(8,0))
food_item = StringVar()
Entry(root, textvariable=food_item, width=45).pack(padx=20)

Label(root, text="Rate the food").pack(anchor="w", padx=20, pady=(8,0))
rating = StringVar(value="5")
Frame(root).pack() 
Radiobutton(root, text="1 - Very Poor", variable=rating, value="1").pack(anchor="w", padx=40)
Radiobutton(root, text="2 - Poor", variable=rating, value="2").pack(anchor="w", padx=40)
Radiobutton(root, text="3 - Average", variable=rating, value="3").pack(anchor="w", padx=40)
Radiobutton(root, text="4 - Good", variable=rating, value="4").pack(anchor="w", padx=40)
Radiobutton(root, text="5 - Excellent", variable=rating, value="5").pack(anchor="w", padx=40)

Label(root, text="", font=("Arial", 11)).pack(pady=6)
result = Label(root, text="", font=("Arial", 11))
result.pack()

Button(root, text="Submit Feedback", width=16, command=lambda: (
    messagebox.showinfo("Thank you","Feedback submitted"),
    result.config(text="Submitted: " + (name.get().strip() or "<anonymous>"))
)).pack(side="left", padx=30, pady=14)

Button(root, text="Reset", width=12, command=lambda: (
    name.set(""),
    room.set(""),
    food_item.set(""),
    rating.set("5"),
    result.config(text="")
)).pack(side="left", padx=10, pady=14)

Button(root, text="Quit", width=12, command=root.destroy).pack(side="right", padx=30, pady=14)

root.mainloop()
