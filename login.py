import tkinter as tk
from tkinter import messagebox

root = tk.Tk()
root.title("User Login")
root.geometry("300x150") 

tk.Button(root, text="Login", bg='lightblue', command=lambda: 
    (
        messagebox.showerror("Login Failed", "Please enter both Username and Password.")
        if not username_entry.get() or not password_entry.get()
        else messagebox.showinfo("Login Successful", f"Welcome, {username_entry.get()}!")
    )
).grid(row=2, column=0, columnspan=2, pady=10)

tk.Label(root, text="Username:").grid(row=0, column=0, sticky='w', padx=10, pady=5)
username_entry = tk.Entry(root, width=25)
username_entry.grid(row=0, column=1, padx=10, pady=5)

tk.Label(root, text="Password:").grid(row=1, column=0, sticky='w', padx=10, pady=5)
password_entry = tk.Entry(root, width=25, show='*') 
password_entry.grid(row=1, column=1, padx=10, pady=5)

root.mainloop()