from tkinter import *
from tkinter import messagebox

root = Tk()
root.title("Help")
root.geometry("520x360")
Label(root, text="App Help", font=("Arial",16)).pack(pady=10)

Label(root, text="Select Topic").pack(anchor="w", padx=12)
topics = Listbox(root, height=6, width=40)
for t in ["Getting Started","Account","Payments","Troubleshooting","Contact Support"]:
    topics.insert(END, t)
topics.pack(padx=12)

Label(root, text="Help Content").pack(anchor="w", padx=12, pady=(8,0))
content = Text(root, height=8, width=60)
content.insert("1.0", "Select a topic from the list and click 'Show' to view dummy help text.")
content.config(state=NORMAL)
content.pack(padx=12)

Button(root, text="Show", width=12, command=lambda: content.delete("1.0","end") or content.insert("1.0", f"Help for: {topics.get(ACTIVE)}\n\nThis is sample help text for demonstration.")).pack(side="left", padx=16, pady=12)
Button(root, text="Contact Us", width=12, command=lambda: messagebox.showinfo("Contact","Email: support@example.com\nPhone: +91-XXXXXXXXXX")).pack(side="left", padx=6, pady=12)
Button(root, text="Close", width=12, command=root.destroy).pack(side="right", padx=16, pady=12)

root.mainloop()
