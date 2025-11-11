from tkinter import *
from tkinter import messagebox

root = Tk()
root.title("Sports Academy Registration")
root.geometry("520x520")
Label(root, text="Sports Academy", font=("Arial",16)).pack(pady=10)

Label(root, text="Athlete Name").pack(anchor="w", padx=16); name=StringVar(); Entry(root, textvariable=name, width=42).pack(padx=16)
Label(root, text="Age").pack(anchor="w", padx=16, pady=(6,0)); age=StringVar(); Entry(root, textvariable=age, width=8).pack(padx=16)
Label(root, text="Select Sport(s)").pack(anchor="w", padx=16, pady=(6,0))

sports = Listbox(root, selectmode=MULTIPLE, height=6)
for s in ["Cricket","Football","Basketball","Tennis","Swimming","Athletics"]:
    sports.insert(END, s)
sports.pack(padx=20)

Label(root, text="Available Batches").pack(anchor="w", padx=16, pady=(6,0))
batch = StringVar(value="Morning")
Radiobutton(root, text="Morning", variable=batch, value="Morning").pack(anchor="w", padx=32)
Radiobutton(root, text="Evening", variable=batch, value="Evening").pack(anchor="w", padx=32)

Label(root, text="Medical Clearance").pack(anchor="w", padx=16, pady=(6,0))
med = IntVar()
Checkbutton(root, text="I have medical clearance", variable=med).pack(anchor="w", padx=32)

Button(root, text="Register", width=14, command=lambda: (messagebox.showinfo("Registered","Registration done (dummy)"),)).pack(side="left", padx=20, pady=12)
Button(root, text="Reset", width=12, command=lambda: (name.set(""), age.set(""), sports.selection_clear(0,END), batch.set("Morning"), med.set(0))).pack(side="left", padx=8, pady=12)
Button(root, text="Quit", width=12, command=root.destroy).pack(side="right", padx=20, pady=12)

root.mainloop()
