from tkinter import *
from tkinter import messagebox

root = Tk()
root.title("Welcome")
root.geometry("480x280")
Label(root, text="Welcome to MyApp", font=("Helvetica",24)).pack(pady=18)
Label(root, text="Simple welcome screen with quick actions", font=("Arial",11)).pack(pady=6)

Button(root, text="Get Started", width=14, command=lambda: messagebox.showinfo("Start","Starting (dummy)")).pack(pady=8)
Button(root, text="Login", width=10, command=lambda: messagebox.showinfo("Login","Go to Login (dummy)")).pack(pady=4)
Button(root, text="Exit", width=10, command=root.destroy).pack(pady=6)

root.mainloop()
