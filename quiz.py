from tkinter import *

root = Tk()
root.title("Simple Online Quiz")
root.geometry("700x700")

Label(root, text="Enter Your Name:").pack(anchor="w", padx=10, pady=(10,0))
name_text = Text(root, height=1, width=40)
name_text.pack(anchor="w", padx=10)

qs = [
    ("1. Which language is this quiz written in?", ["Java", "Python", "C++", "HTML"], [False, True, False, False]),
    ("2. Which widget allows multiple selections?", ["Radiobutton", "Entry", "Checkbutton", "Label"], [False, False, True, False]),
    ("3. Which method starts the Tkinter event loop?", ["run()", "start()", "mainloop()", "loop()"], [False, False, True, False]),
    ("4. Which is a text widget for multi-line input?", ["Entry", "Text", "Canvas", "Button"], [False, True, False, False]),
    ("5. Which layout managers exist in Tkinter?", ["pack", "grid", "place", "all of the above"], [False, False, False, True])
]

vars_by_q = []
frame = Frame(root)
frame.pack(fill="both", expand=True, padx=10, pady=10)

for qtext, opts, mask in qs:
    Label(frame, text=qtext).pack(anchor="w", pady=(8,0))
    vs = []
    for opt in opts:
        v = BooleanVar(value=False)
        Checkbutton(frame, text=opt, variable=v).pack(anchor="w")
        vs.append(v)
    vars_by_q.append((vs, mask))

result_label = Label(root, text="", font=("Arial", 12))
result_label.pack(pady=10)

def submit():
    score = 0
    for v, m in vars_by_q:
        if all(v_i.get() == m_i for v_i, m_i in zip(v, m)):
            score += 1
    name = name_text.get("1.0", "end").strip()
    result_label.config(text=f"Name: {name}    Score: {score}/{len(vars_by_q)}")

def reset():
    for v, _ in vars_by_q:
        for v_i in v:
            v_i.set(False)
    name_text.delete("1.0", "end")
    result_label.config(text="")

Button(root, text="Submit", command=submit).pack(side="left", padx=20, pady=10)
Button(root, text="Reset", command=reset).pack(side="left", padx=10, pady=10)
Button(root, text="Quit", command=root.destroy).pack(side="right", padx=20, pady=10)

root.mainloop()
