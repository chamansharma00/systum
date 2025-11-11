from tkinter import *
from tkinter import messagebox

root = Tk()
root.title("Patient Registration")
root.geometry("480x520")
Label(root, text="Patient Registration", font=("Arial",16)).pack(pady=8)

Label(root, text="Full Name").pack(anchor="w", padx=16); name=StringVar(); Entry(root, textvariable=name, width=40).pack(padx=16)
Label(root, text="Age").pack(anchor="w", padx=16, pady=(6,0)); age=StringVar(); Entry(root, textvariable=age, width=10).pack(padx=16)
Label(root, text="Gender").pack(anchor="w", padx=16, pady=(6,0)); gender=StringVar(value="Male")
Radiobutton(root, text="Male", variable=gender, value="Male").pack(anchor="w", padx=32)
Radiobutton(root, text="Female", variable=gender, value="Female").pack(anchor="w", padx=32)
Label(root, text="Contact").pack(anchor="w", padx=16, pady=(6,0)); contact=StringVar(); Entry(root, textvariable=contact, width=30).pack(padx=16)

Label(root, text="Symptoms / Notes").pack(anchor="w", padx=16, pady=(6,0))
notes = Text(root, height=6, width=50); notes.pack(padx=16)

Label(root, text="Known Allergies").pack(anchor="w", padx=16, pady=(6,0))
alb1=IntVar(); alb2=IntVar()
Checkbutton(root, text="Penicillin", variable=alb1).pack(anchor="w", padx=32)
Checkbutton(root, text="Food", variable=alb2).pack(anchor="w", padx=32)

Label(root, text="Visit Type").pack(anchor="w", padx=16, pady=(6,0))
visit = StringVar(value="OPD")
Radiobutton(root, text="OPD", variable=visit, value="OPD").pack(anchor="w", padx=32)
Radiobutton(root, text="Emergency", variable=visit, value="Emergency").pack(anchor="w", padx=32)

result = Label(root, text="", font=("Arial",11)); result.pack(pady=8)
Button(root, text="Register", width=14, command=lambda: (messagebox.showinfo("Done","Patient Registered (dummy)"), result.config(text="Registered: "+(name.get().strip() or "<no name>")))).pack(side="left", padx=20, pady=12)
Button(root, text="Reset", width=12, command=lambda: (name.set(""), age.set(""), gender.set("Male"), contact.set(""), notes.delete("1.0","end"), alb1.set(0), alb2.set(0), visit.set("OPD"), result.config(text=""))).pack(side="left", padx=6, pady=12)
Button(root, text="Quit", width=12, command=root.destroy).pack(side="right", padx=20, pady=12)

root.mainloop()
