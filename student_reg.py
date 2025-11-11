import tkinter as tk
from tkinter import messagebox

root = tk.Tk()
root.title("Student Registration")
root.geometry("400x400")

math_var = tk.IntVar()
science_var = tk.IntVar()
history_var = tk.IntVar()

tk.Label(root, text="Student Name:").grid(row=0, column=0, sticky='w', padx=10, pady=5)
name_entry = tk.Entry(root, width=30)
name_entry.grid(row=0, column=1, padx=10, pady=5)

tk.Label(root, text="Student ID:").grid(row=1, column=0, sticky='w', padx=10, pady=5)
id_entry = tk.Entry(root, width=30)
id_entry.grid(row=1, column=1, padx=10, pady=5)

tk.Label(root, text="Course Enrollment:").grid(row=2, column=0, sticky='w', padx=10, pady=10)
tk.Checkbutton(root, text="Math", variable=math_var).grid(row=3, column=0, sticky='w', padx=10)
tk.Checkbutton(root, text="Science", variable=science_var).grid(row=3, column=1, sticky='w', padx=10)
tk.Checkbutton(root, text="History", variable=history_var).grid(row=4, column=0, sticky='w', padx=10)

tk.Label(root, text="Select Grade:").grid(row=5, column=0, sticky='w', padx=10, pady=10)

grades = ["Grade 9", "Grade 10", "Grade 11", "Grade 12", "Grade 13 (A-Level)"]

grade_listbox = tk.Listbox(root, height=5, width=25, selectmode=tk.SINGLE)
grade_listbox.grid(row=6, column=0, columnspan=2, padx=10, pady=5)

for grade in grades:
    grade_listbox.insert(tk.END, grade)

tk.Button(root, text="Register Student", bg='lightgreen', command=lambda: 
    (
        messagebox.showerror("Registration Failed", "Please enter both Name and Student ID.")
        if not name_entry.get() or not id_entry.get()
        else messagebox.showinfo("Registration Successful", "Registration was successful!")
    )
).grid(row=7, column=0, columnspan=2, pady=20)

root.mainloop()