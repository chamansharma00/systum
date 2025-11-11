from tkinter import *
from tkinter import messagebox

root = Tk()
root.title("Fund Transfer")
root.geometry("420x380")

Label(root, text="Bank Transfer", font=("Arial", 16)).pack(pady=12)

Label(root, text="From Account Number").pack(anchor="w", padx=20)
from_acc = StringVar()
Entry(root, textvariable=from_acc, width=36).pack(padx=20)

Label(root, text="To Account Number / UPI ID").pack(anchor="w", padx=20, pady=(8,0))
to_acc = StringVar()
Entry(root, textvariable=to_acc, width=36).pack(padx=20)

Label(root, text="Amount (₹)").pack(anchor="w", padx=20, pady=(8,0))
amount = StringVar()
Entry(root, textvariable=amount, width=20).pack(padx=20)

Label(root, text="Transfer Mode").pack(anchor="w", padx=20, pady=(8,0))
mode = StringVar(value="UPI")
Frame(root).pack()
Radiobutton(root, text="UPI", variable=mode, value="UPI").pack(anchor="w", padx=40)

confirm = IntVar()
Checkbutton(root, text="I confirm to transfer the above amount", variable=confirm).pack(pady=8)

result = Label(root, text="", font=("Arial", 11))
result.pack()

Button(root, text="Submit", width=14, command=lambda: (
    messagebox.showinfo("Transaction", "Transaction Successful!") 
)).pack(side="left", padx=30, pady=12)

Button(root, text="Quit", width=12, command=root.destroy).pack(side="right", padx=30, pady=12)

root.mainloop()
