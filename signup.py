from tkinter import *
from tkinter import messagebox

root = Tk()
root.title("Sign Up Window")
root.geometry("400x450")
root.resizable(False, False)

Label(root, text="Create Account", font=("Arial", 16)).pack(pady=10)

Label(root, text="Full Name").pack(anchor="w", padx=20)
Entry(root, width=40).pack(padx=20)

Label(root, text="Email").pack(anchor="w", padx=20, pady=(8,0))
Entry(root, width=40).pack(padx=20)

Label(root, text="Password").pack(anchor="w", padx=20, pady=(8,0))
Entry(root, show="*", width=40).pack(padx=20)

Label(root, text="Confirm Password").pack(anchor="w", padx=20, pady=(8,0))
Entry(root, show="*", width=40).pack(padx=20)

Label(root, text="Gender").pack(anchor="w", padx=20, pady=(8,0))
gender_var = StringVar(value="Male")
Radiobutton(root, text="Male", variable=gender_var, value="Male").pack(anchor="w", padx=40)
Radiobutton(root, text="Female", variable=gender_var, value="Female").pack(anchor="w", padx=40)

Checkbutton(root, text="I agree to the Terms & Conditions").pack(pady=10)

def submit():
    messagebox.showinfo("Success", "Account Created Successfully!")

Button(root, text="Submit", width=12, command=submit).pack(pady=10)
Button(root, text="Quit", width=12, command=root.destroy).pack()

root.mainloop()
