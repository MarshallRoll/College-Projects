from tkinter import *
from tkinter import ttk

def main():
    myGUI = TriviaGameMenu()
    myGUI.go()

class TriviaGameMenu():
    def __init__(self):
        self.mainWindow = Tk()
        self.mainWindow.title("Trivia")

        # Title Label
        self.titleLabel = Label(self.mainWindow, text = "Trivia", font = "Times 25", justify = CENTER)
        self.titleLabel.grid(row = 0, column = 2)

        # Category Label
        self.enterCategoryLabel1 = Label(self.mainWindow, text="       Years       ", font="Times 18",
                                         justify = CENTER, padx = 15, pady = 15)
        self.enterCategoryLabel1.grid(row=2, column=1)
        self.enterCategoryLabel2 = Label(self.mainWindow, text="    Math   ", font="Times 18",
                                         justify = CENTER, padx = 15, pady = 15)
        self.enterCategoryLabel2.grid(row=2, column=2)
        self.enterCategoryLabel1 = Label(self.mainWindow, text="Texting Lingo", font="Times 18",
                                         justify = CENTER, padx = 15, pady = 15)
        self.enterCategoryLabel1.grid(row=2, column=3)

        #Question Buttons
        self.question1 = Button(self.mainWindow, text="$200", padx = 25, pady = 15,
                                bg = "blue", fg = "goldenrod", font = "Times 20",
                                command=self.question1)
        self.question1.grid(row=3, column=1, rowspan = 3)

        self.question2 = Button(self.mainWindow, text="$400", padx = 25, pady = 15,
                                bg = "blue", fg = "goldenrod", font = "Times 20",
                                command=self.question2)
        self.question2.grid(row=6, column=1, rowspan = 3)

        self.question3 = Button(self.mainWindow, text="$600", padx = 25, pady = 15,
                                bg = "blue", fg = "goldenrod", font = "Times 20",
                                command=self.question3)
        self.question3.grid(row=9, column=1, rowspan = 3)

        self.question4 = Button(self.mainWindow, text="$200", padx=25, pady=15,
                                bg="blue", fg="goldenrod", font="Times 20",
                                command=self.question4)
        self.question4.grid(row=3, column=2, rowspan=3)

        self.question5 = Button(self.mainWindow, text="$400", padx=25, pady=15,
                                bg="blue", fg="goldenrod", font="Times 20",
                                command=self.question5)
        self.question5.grid(row=6, column=2, rowspan=3)

        self.question6 = Button(self.mainWindow, text="$600", padx=25, pady=15,
                                bg="blue", fg="goldenrod", font="Times 20",
                                command=self.question6)
        self.question6.grid(row=9, column=2, rowspan=3)

        self.question7 = Button(self.mainWindow, text="$200", padx=25, pady=15,
                                bg="blue", fg="goldenrod", font="Times 20",
                                command=self.question7)
        self.question7.grid(row=3, column=3, rowspan=3)

        self.question8 = Button(self.mainWindow, text="$400", padx=25, pady=15,
                                bg="blue", fg="goldenrod", font="Times 20",
                                command=self.question8)
        self.question8.grid(row=6, column=3, rowspan=3)

        self.question9 = Button(self.mainWindow, text="$600", padx=25, pady=15,
                                bg="blue", fg="goldenrod", font="Times 20",
                                command=self.question9)
        self.question9.grid(row=9, column=3, rowspan=3)

        # Restart Button
        self.restart = ttk.Button(self.mainWindow, text="Restart", command = self.restart)
        self.restart.grid(row=12, column=0)

        # Quit Button
        self.quit = ttk.Button(self.mainWindow, text="Quit", command = self.quit)
        self.quit.grid(row=12, column=4)

        # Score Label
        self.scoreLabel = Label(self.mainWindow,
                                text="Score:",
                                font="Times 20",
                                justify=CENTER,
                                fg="blue",
                                height = -67,
                                padx=30,
                                pady=8)
        self.scoreLabel.grid(row=3, column=0)

        # Value Label

        self.valueLabel = Label(self.mainWindow,
                                text="$0",
                                font="Times 20",
                                justify=CENTER,
                                fg="blue",
                                bg = "goldenrod",
                                padx=15)
        self.valueLabel.grid(row=4, column=0)

        listVar = []
        global listSum
        listSum = 0
        global num
        num = 0
        try:
            question1Score
        except NameError:
            pass
        else:
            newList = listVar + [question1Score]
            num = num + 1
            for i in range(len(newList)):
                listSum = listSum + int(newList[i])
            self.valueLabel["text"] = "$" + str(listSum)
            self.question1["state"] = 'disabled'
            self.question1["bg"] = 'gray'
        try:
            question2Score
        except NameError:
            pass
        else:
            num = num + 1
            newList = listVar + [question2Score]
            for i in range(len(newList)):
                listSum = listSum + int(newList[i])
            self.valueLabel["text"] = "$" + str(listSum)
            self.question2["state"] = 'disabled'
            self.question2["bg"] = 'gray'
        try:
            question3Score
        except NameError:
            pass
        else:
            num = num + 1
            newList = listVar + [question3Score]
            for i in range(len(newList)):
                listSum = listSum + int(newList[i])
            self.valueLabel["text"] = "$" + str(listSum)
            self.question3["state"] = 'disabled'
            self.question3["bg"] = 'gray'
        try:
            question4Score
        except NameError:
            pass
        else:
            num = num + 1
            newList = listVar + [question4Score]
            for i in range(len(newList)):
                listSum = listSum + int(newList[i])
            self.valueLabel["text"] = "$" + str(listSum)
            self.question4["state"] = 'disabled'
            self.question4["bg"] = 'gray'
        try:
            question5Score
        except NameError:
            pass
        else:
            num = num + 1
            newList = listVar + [question5Score]
            for i in range(len(newList)):
                listSum = listSum + int(newList[i])
            self.valueLabel["text"] = "$" + str(listSum)
            self.question5["state"] = 'disabled'
            self.question5["bg"] = 'gray'
        try:
            question6Score
        except NameError:
            pass
        else:
            num = num + 1
            newList = listVar + [question6Score]
            for i in range(len(newList)):
                listSum = listSum + int(newList[i])
            self.valueLabel["text"] = "$" + str(listSum)
            self.question6["state"] = 'disabled'
            self.question6["bg"] = 'gray'
        try:
            question7Score
        except NameError:
            pass
        else:
            num = num + 1
            newList = listVar + [question7Score]
            for i in range(len(newList)):
                listSum = listSum + int(newList[i])
            self.valueLabel["text"] = "$" + str(listSum)
            self.question7["state"] = 'disabled'
            self.question7["bg"] = 'gray'
        try:
            question8Score
        except NameError:
            pass
        else:
            num = num + 1
            newList = listVar + [question8Score]
            for i in range(len(newList)):
                listSum = listSum + int(newList[i])
            self.valueLabel["text"] = "$" + str(listSum)
            self.question8["state"] = 'disabled'
            self.question8["bg"] = 'gray'
        try:
            question9Score
        except NameError:
            pass
        else:
            num = num + 1
            newList = listVar + [question9Score]
            for i in range(len(newList)):
                listSum = listSum + int(newList[i])
            self.valueLabel["text"] = "$" + str(listSum)
            self.question9["state"] = 'disabled'
            self.question9["bg"] = 'gray'

        if num == 9:
            self.mainWindow.destroy()
            chooseAmount()

        # Dummy Labels
        # to adjust the spacing between the buttons so that they are the same

        self.dummyLabel = Label(self.mainWindow,
                                text="",
                                font="Times 20",
                                justify=CENTER,
                                fg="blue",
                                padx=30,
                                pady = 13)
        self.dummyLabel.grid(row=6, column=4)
        self.dummLabel = Label(self.mainWindow,
                                text="",
                                font="Times 20",
                                justify=CENTER,
                                padx=40,
                                pady = 8)
        self.dummLabel.grid(row=8, column=4)

    def go(self):
        self.mainWindow.mainloop()
    def quit(self):
        self.mainWindow.destroy()
    def question1(self):
        self.mainWindow.destroy()
        TriviaGameQ1()
    def question2(self):
        self.mainWindow.destroy()
        TriviaGameQ2()
    def question3(self):
        self.mainWindow.destroy()
        TriviaGameQ3()
    def question4(self):
        self.mainWindow.destroy()
        TriviaGameQ4()
    def question5(self):
        self.mainWindow.destroy()
        TriviaGameQ5()
    def question6(self):
        self.mainWindow.destroy()
        TriviaGameQ6()
    def question7(self):
        self.mainWindow.destroy()
        TriviaGameQ7()
    def question8(self):
        self.mainWindow.destroy()
        TriviaGameQ8()
    def question9(self):
        self.mainWindow.destroy()
        TriviaGameQ9()
    def restart(self):
        global question1Score
        global question2Score
        global question3Score
        global question4Score
        global question5Score
        global question6Score
        global question7Score
        global question8Score
        global question9Score
        listVar = []
        listSum = 0
        try:
            question1Score
        except NameError:
            pass
        else:
            del question1Score
        try:
            question2Score
        except NameError:
            pass
        else:
            del question2Score
        try:
            question3Score
        except NameError:
            pass
        else:
            del question3Score
        try:
            question4Score
        except NameError:
            pass
        else:
            del question4Score
        try:
            question5Score
        except NameError:
            pass
        else:
            del question5Score
        try:
            question6Score
        except NameError:
            pass
        else:
            del question6Score
        try:
            question7Score
        except NameError:
            pass
        else:
            del question7Score
        try:
            question8Score
        except NameError:
            pass
        else:
            del question8Score
        try:
            question9Score
        except NameError:
            pass
        else:
            del question9Score
        self.valueLabel["text"] = "$0"
        self.mainWindow.destroy()
        TriviaGameMenu()


class TriviaGameQ1:
    def __init__(self):
        self.mainWindow = Tk()
        self.mainWindow.title("Years, $200")

        # Title Label
        self.titleLabel = Label(self.mainWindow, text="Years, $200", font="Times 25",
                                fg = "blue", justify=CENTER)
        self.titleLabel.grid(row=0, column=1)

        # Question Text
        self.QuestionText = Label(self.mainWindow, text="In this year, Fidel Castro resigned as president of Cuba,\na global financial crisis hit the world's banking systems, and \nBarack Obama was first elected as President of the United States.",
                                  font="Times 15", width = 50, justify=CENTER)
        self.QuestionText.grid(row=1, column=1, rowspan = 1)

        # Entry Box
        self.guessEntry = Entry(self.mainWindow, font="Arial 20", justify = CENTER, bd=10, width=5)
        self.guessEntry.grid(row=7, column=1)
        self.guessEntry.bind('<Return>', self.check)

        # Check Guess Button
        self.checkGuess = ttk.Button(self.mainWindow, text="Check Guess", command=self.check)
        self.checkGuess.grid(row=8, column=1)

        # Correct Answer
        self.correctAnswer = Label(self.mainWindow,
                                   text = "",
                                   fg = "green",
                                   justify=CENTER,
                                   font = "Times 20",
                                   padx=10,
                                   pady=10
                                   )
        self.correctAnswer.grid(row=2, column=1, rowspan=2)

        # Incorrect Answer
        self.incorrectAnswer = Label(self.mainWindow,
                                   text="",
                                   font = "Times 20",
                                   fg="red",
                                   justify=CENTER,
                                   padx=10
                                   )
        self.incorrectAnswer.grid(row=2, column=1)

        # Answer Label
        self.answerLabel = Label(self.mainWindow,
                               text="",
                               font="Times 20",
                               justify=CENTER,
                               padx=10
                               )
        self.answerLabel.grid(row=3, column=1, rowspan=2)

        # Back Button
        self.back = ttk.Button(self.mainWindow, text="Back", command=self.mainMenu)
        self.back.grid(row=9, column=0)


        # Quit Guess
        self.quitGuess = ttk.Button(self.mainWindow, text="Quit", command=self.quit)
        self.quitGuess.grid(row=9, column=2)


    def check(self, event = None):
        global question1Score
        guess = str(self.guessEntry.get())
        answer = "2008"
        if guess != answer:
            self.correctAnswer.destroy()
            self.incorrectAnswer["text"] = "Incorrect!"
            self.answerLabel["text"] = "The correct answer was " + str(answer)
            self.guessEntry["state"] = 'disabled'
            question1Score = 0
        elif guess == answer:
            self.correctAnswer["text"] = "That's right!"
            self.incorrectAnswer.destroy()
            self.answerLabel.destroy()
            self.guessEntry["state"] = 'disabled'
            question1Score = 200


    def quit(self):
        self.mainWindow.destroy()

    def mainMenu(self):
        self.mainWindow.destroy()
        TriviaGameMenu()

class TriviaGameQ2:
    def __init__(self):
        self.mainWindow = Tk()
        self.mainWindow.title("Years, $400")

        # Title Label
        self.titleLabel = Label(self.mainWindow, text="Years, $400", font="Times 25",
                                fg = "blue", justify=CENTER)
        self.titleLabel.grid(row=0, column=1)

        # Question Text
        self.QuestionText = Label(self.mainWindow, text="In this year, the Euro was officially established as a currency and\nthe first movie in the Star Wars prequel trilogy was released.\nName this year that titles a hit song by Prince.",
                                  font="Times 15", width = 50, justify=CENTER)
        self.QuestionText.grid(row=1, column=1, rowspan = 1)

        # Entry Box
        self.guessEntry = Entry(self.mainWindow, font="Arial 20", justify = CENTER, bd=10, width=5)
        self.guessEntry.grid(row=7, column=1)
        self.guessEntry.bind('<Return>', self.check)

        # Check Guess Button
        self.checkGuess = ttk.Button(self.mainWindow, text="Check Guess", command=self.check)
        self.checkGuess.grid(row=8, column=1)

        # Correct Answer
        self.correctAnswer = Label(self.mainWindow,
                                   text = "",
                                   fg = "green",
                                   justify=CENTER,
                                   font = "Times 20",
                                   padx=10,
                                   pady=10
                                   )
        self.correctAnswer.grid(row=2, column=1, rowspan=2)

        # Incorrect Answer
        self.incorrectAnswer = Label(self.mainWindow,
                                   text="",
                                   font = "Times 20",
                                   fg="red",
                                   justify=CENTER,
                                   padx=10
                                   )
        self.incorrectAnswer.grid(row=2, column=1)

        # Answer Label
        self.answerLabel = Label(self.mainWindow,
                               text="",
                               font="Times 20",
                               justify=CENTER,
                               padx=10
                               )
        self.answerLabel.grid(row=3, column=1, rowspan=2)

        # Back Button
        self.back = ttk.Button(self.mainWindow, text="Back", command=self.mainMenu)
        self.back.grid(row=9, column=0)


        # Quit Guess
        self.quitGuess = ttk.Button(self.mainWindow, text="Quit", command=self.quit)
        self.quitGuess.grid(row=9, column=2)


    def check(self, event = None):
        global question2Score
        guess = str(self.guessEntry.get())
        answer = "1999"
        if guess != answer:
            self.correctAnswer.destroy()
            self.incorrectAnswer["text"] = "Incorrect!"
            self.answerLabel["text"] = "The correct answer was " + str(answer)
            self.guessEntry["state"] = 'disabled'
            question2Score = 0
        elif guess == answer:
            self.correctAnswer["text"] = "That's right!"
            self.incorrectAnswer.destroy()
            self.answerLabel.destroy()
            self.guessEntry["state"] = 'disabled'
            question2Score = 400

    def quit(self):
        self.mainWindow.destroy()

    def mainMenu(self):
        self.mainWindow.destroy()
        TriviaGameMenu()

class TriviaGameQ3:
    def __init__(self):
        self.mainWindow = Tk()
        self.mainWindow.title("Years, $600")

        # Title Label
        self.titleLabel = Label(self.mainWindow, text="Years, $600", font="Times 25",
                                fg = "blue", justify=CENTER)
        self.titleLabel.grid(row=0, column=1)

        # Question Text
        self.QuestionText = Label(self.mainWindow, text="The first commercial flight aboard a Boeing 747 took place in\n this year, which was also when the Aswan High Dam was completed.\nName this year in which the Beatles broke up.",
                                  font="Times 15", width = 50, justify=CENTER)
        self.QuestionText.grid(row=1, column=1, rowspan = 1)

        # Entry Box
        self.guessEntry = Entry(self.mainWindow, font="Arial 20", justify = CENTER, bd=10, width=5)
        self.guessEntry.grid(row=7, column=1)
        self.guessEntry.bind('<Return>', self.check)

        # Check Guess Button
        self.checkGuess = ttk.Button(self.mainWindow, text="Check Guess", command=self.check)
        self.checkGuess.grid(row=8, column=1)

        # Correct Answer
        self.correctAnswer = Label(self.mainWindow,
                                   text = "",
                                   fg = "green",
                                   justify=CENTER,
                                   font = "Times 20",
                                   padx=10,
                                   pady=10
                                   )
        self.correctAnswer.grid(row=2, column=1, rowspan=2)

        # Incorrect Answer
        self.incorrectAnswer = Label(self.mainWindow,
                                   text="",
                                   font = "Times 20",
                                   fg="red",
                                   justify=CENTER,
                                   padx=10
                                   )
        self.incorrectAnswer.grid(row=2, column=1)

        # Answer Label
        self.answerLabel = Label(self.mainWindow,
                               text="",
                               font="Times 20",
                               justify=CENTER,
                               padx=10
                               )
        self.answerLabel.grid(row=3, column=1, rowspan=2)

        # Back Button
        self.back = ttk.Button(self.mainWindow, text="Back", command=self.mainMenu)
        self.back.grid(row=9, column=0)


        # Quit Guess
        self.quitGuess = ttk.Button(self.mainWindow, text="Quit", command=self.quit)
        self.quitGuess.grid(row=9, column=2)


    def check(self, event = None):
        global question3Score
        guess = str(self.guessEntry.get())
        answer = "1970"
        if guess != answer:
            self.correctAnswer.destroy()
            self.incorrectAnswer["text"] = "Incorrect!"
            self.answerLabel["text"] = "The correct answer was " + str(answer)
            self.guessEntry["state"] = 'disabled'
            question3Score = 0
        elif guess == answer:
            self.correctAnswer["text"] = "That's right!"
            self.incorrectAnswer.destroy()
            self.answerLabel.destroy()
            self.guessEntry["state"] = 'disabled'
            question3Score = 600

    def quit(self):
        self.mainWindow.destroy()

    def mainMenu(self):
        self.mainWindow.destroy()
        TriviaGameMenu()

class TriviaGameQ4:
    def __init__(self):
        self.mainWindow = Tk()
        self.mainWindow.title("Math, $200")

        # Title Label
        self.titleLabel = Label(self.mainWindow, text="Math, $200", font="Times 25",
                                fg = "blue", justify=CENTER)
        self.titleLabel.grid(row=0, column=1)

        # Question Text
        self.QuestionText = Label(self.mainWindow, text="What is the result when 92 is increased by 25%?",
                                  font="Times 15", width = 50, justify=CENTER)
        self.QuestionText.grid(row=1, column=1, rowspan = 1)

        # Entry Box
        self.guessEntry = Entry(self.mainWindow, font="Arial 20", justify = CENTER, bd=10, width=5)
        self.guessEntry.grid(row=7, column=1)
        self.guessEntry.bind('<Return>', self.check)

        # Check Guess Button
        self.checkGuess = ttk.Button(self.mainWindow, text="Check Guess", command=self.check)
        self.checkGuess.grid(row=8, column=1)

        # Correct Answer
        self.correctAnswer = Label(self.mainWindow,
                                   text = "",
                                   fg = "green",
                                   justify=CENTER,
                                   font = "Times 20",
                                   padx=10,
                                   pady=10
                                   )
        self.correctAnswer.grid(row=2, column=1, rowspan=2)

        # Incorrect Answer
        self.incorrectAnswer = Label(self.mainWindow,
                                   text="",
                                   font = "Times 20",
                                   fg="red",
                                   justify=CENTER,
                                   padx=10
                                   )
        self.incorrectAnswer.grid(row=2, column=1)

        # Answer Label
        self.answerLabel = Label(self.mainWindow,
                               text="",
                               font="Times 20",
                               justify=CENTER,
                               padx=10
                               )
        self.answerLabel.grid(row=3, column=1, rowspan=2)

        # Back Button
        self.back = ttk.Button(self.mainWindow, text="Back", command=self.mainMenu)
        self.back.grid(row=9, column=0)


        # Quit Guess
        self.quitGuess = ttk.Button(self.mainWindow, text="Quit", command=self.quit)
        self.quitGuess.grid(row=9, column=2)


    def check(self, event = None):
        global question4Score
        guess = str(self.guessEntry.get())
        answer = "115"
        if guess != answer:
            self.correctAnswer.destroy()
            self.incorrectAnswer["text"] = "Incorrect!"
            self.answerLabel["text"] = "The correct answer was " + str(answer)
            self.guessEntry["state"] = 'disabled'
            question4Score = 0
        elif guess == answer:
            self.correctAnswer["text"] = "That's right!"
            self.incorrectAnswer.destroy()
            self.answerLabel.destroy()
            self.guessEntry["state"] = 'disabled'
            question4Score = 200

    def quit(self):
        self.mainWindow.destroy()

    def mainMenu(self):
        self.mainWindow.destroy()
        TriviaGameMenu()


class TriviaGameQ5:
    def __init__(self):
        self.mainWindow = Tk()
        self.mainWindow.title("Math, $400")

        # Title Label
        self.titleLabel = Label(self.mainWindow, text="Math, $400", font="Times 25",
                                fg = "blue", justify=CENTER)
        self.titleLabel.grid(row=0, column=1)

        # Question Text
        self.QuestionText = Label(self.mainWindow, text="What is the quotient when 9! (factorial) is divided by 7! (factorial)?",
                                  font="Times 15", width = 50, justify=CENTER)
        self.QuestionText.grid(row=1, column=1, rowspan = 1)

        # Entry Box
        self.guessEntry = Entry(self.mainWindow, font="Arial 20", justify = CENTER, bd=10, width=5)
        self.guessEntry.grid(row=7, column=1)
        self.guessEntry.bind('<Return>', self.check)

        # Check Guess Button
        self.checkGuess = ttk.Button(self.mainWindow, text="Check Guess", command=self.check)
        self.checkGuess.grid(row=8, column=1)

        # Correct Answer
        self.correctAnswer = Label(self.mainWindow,
                                   text = "",
                                   fg = "green",
                                   justify=CENTER,
                                   font = "Times 20",
                                   padx=10,
                                   pady=10
                                   )
        self.correctAnswer.grid(row=2, column=1, rowspan=2)

        # Incorrect Answer
        self.incorrectAnswer = Label(self.mainWindow,
                                   text="",
                                   font = "Times 20",
                                   fg="red",
                                   justify=CENTER,
                                   padx=10
                                   )
        self.incorrectAnswer.grid(row=2, column=1)

        # Answer Label
        self.answerLabel = Label(self.mainWindow,
                               text="",
                               font="Times 20",
                               justify=CENTER,
                               padx=10
                               )
        self.answerLabel.grid(row=3, column=1, rowspan=2)

        # Back Button
        self.back = ttk.Button(self.mainWindow, text="Back", command=self.mainMenu)
        self.back.grid(row=9, column=0)


        # Quit Guess
        self.quitGuess = ttk.Button(self.mainWindow, text="Quit", command=self.quit)
        self.quitGuess.grid(row=9, column=2)


    def check(self, event = None):
        global question5Score
        guess = str(self.guessEntry.get())
        answer = "72"
        if guess != answer:
            self.correctAnswer.destroy()
            self.incorrectAnswer["text"] = "Incorrect!"
            self.answerLabel["text"] = "The correct answer was " + str(answer)
            self.guessEntry["state"] = 'disabled'
            question5Score = 0
        elif guess == answer:
            self.correctAnswer["text"] = "That's right!"
            self.incorrectAnswer.destroy()
            self.answerLabel.destroy()
            self.guessEntry["state"] = 'disabled'
            question5Score = 400

    def quit(self):
        self.mainWindow.destroy()

    def mainMenu(self):
        self.mainWindow.destroy()
        TriviaGameMenu()

class TriviaGameQ6:
    def __init__(self):
        self.mainWindow = Tk()
        self.mainWindow.title("Math, $600")

        # Title Label
        self.titleLabel = Label(self.mainWindow, text="Math, $600", font="Times 25",
                                fg = "blue", justify=CENTER)
        self.titleLabel.grid(row=0, column=1)

        # Question Text
        self.QuestionText = Label(self.mainWindow, text="There are only chickens and cows in a field. In total, I count\n32 heads and 92 legs. How many chickens are in the field?",
                                  font="Times 15", width = 50, justify=CENTER)
        self.QuestionText.grid(row=1, column=1, rowspan = 1)

        # Entry Box
        self.guessEntry = Entry(self.mainWindow, font="Arial 20", justify = CENTER, bd=10, width=5)
        self.guessEntry.grid(row=7, column=1)
        self.guessEntry.bind('<Return>', self.check)

        # Check Guess Button
        self.checkGuess = ttk.Button(self.mainWindow, text="Check Guess", command=self.check)
        self.checkGuess.grid(row=8, column=1)

        # Correct Answer
        self.correctAnswer = Label(self.mainWindow,
                                   text = "",
                                   fg = "green",
                                   justify=CENTER,
                                   font = "Times 20",
                                   padx=10,
                                   pady=10
                                   )
        self.correctAnswer.grid(row=2, column=1, rowspan=2)

        # Incorrect Answer
        self.incorrectAnswer = Label(self.mainWindow,
                                   text="",
                                   font = "Times 20",
                                   fg="red",
                                   justify=CENTER,
                                   padx=10
                                   )
        self.incorrectAnswer.grid(row=2, column=1)

        # Answer Label
        self.answerLabel = Label(self.mainWindow,
                               text="",
                               font="Times 20",
                               justify=CENTER,
                               padx=10
                               )
        self.answerLabel.grid(row=3, column=1, rowspan=2)

        # Back Button
        self.back = ttk.Button(self.mainWindow, text="Back", command=self.mainMenu)
        self.back.grid(row=9, column=0)


        # Quit Guess
        self.quitGuess = ttk.Button(self.mainWindow, text="Quit", command=self.quit)
        self.quitGuess.grid(row=9, column=2)


    def check(self, event = None):
        global question6Score
        guess = str(self.guessEntry.get())
        answer = "18"
        if guess != answer:
            self.correctAnswer.destroy()
            self.incorrectAnswer["text"] = "Incorrect!"
            self.answerLabel["text"] = "The correct answer was " + str(answer)
            self.guessEntry["state"] = 'disabled'
            question6Score = 0
        elif guess == answer:
            self.correctAnswer["text"] = "That's right!"
            self.incorrectAnswer.destroy()
            self.answerLabel.destroy()
            self.guessEntry["state"] = 'disabled'
            question6Score = 600

    def quit(self):
        self.mainWindow.destroy()

    def mainMenu(self):
        self.mainWindow.destroy()
        TriviaGameMenu()

class TriviaGameQ7:
    def __init__(self):
        self.mainWindow = Tk()
        self.mainWindow.title("Texting Lingo, $200")

        # Title Label
        self.titleLabel = Label(self.mainWindow, text="Texting Lingo, $200", font="Times 25",
                                fg = "blue", justify=CENTER)
        self.titleLabel.grid(row=0, column=1)

        # Question Text
        self.QuestionText = Label(self.mainWindow, text="3 letters, used to indicate a great deal of chuckling",
                                  font="Times 15", width = 50, justify=CENTER)
        self.QuestionText.grid(row=1, column=1, rowspan = 1)

        # Entry Box
        self.guessEntry = Entry(self.mainWindow, font="Arial 20", justify = CENTER, bd=10, width=5)
        self.guessEntry.grid(row=7, column=1)
        self.guessEntry.bind('<Return>', self.check)

        # Check Guess Button
        self.checkGuess = ttk.Button(self.mainWindow, text="Check Guess", command=self.check)
        self.checkGuess.grid(row=8, column=1)

        # Correct Answer
        self.correctAnswer = Label(self.mainWindow,
                                   text = "",
                                   fg = "green",
                                   justify=CENTER,
                                   font = "Times 20",
                                   padx=10,
                                   pady=10
                                   )
        self.correctAnswer.grid(row=2, column=1, rowspan=2)

        # Incorrect Answer
        self.incorrectAnswer = Label(self.mainWindow,
                                   text="",
                                   font = "Times 20",
                                   fg="red",
                                   justify=CENTER,
                                   padx=10
                                   )
        self.incorrectAnswer.grid(row=2, column=1)

        # Answer Label
        self.answerLabel = Label(self.mainWindow,
                               text="",
                               font="Times 20",
                               justify=CENTER,
                               padx=10
                               )
        self.answerLabel.grid(row=3, column=1, rowspan=2)

        # Back Button
        self.back = ttk.Button(self.mainWindow, text="Back", command=self.mainMenu)
        self.back.grid(row=9, column=0)


        # Quit Guess
        self.quitGuess = ttk.Button(self.mainWindow, text="Quit", command=self.quit)
        self.quitGuess.grid(row=9, column=2)


    def check(self, event = None):
        global question7Score
        guess = str(self.guessEntry.get())
        guess = guess.lower()
        answer = "lol"
        if guess != answer:
            self.correctAnswer.destroy()
            self.incorrectAnswer["text"] = "Incorrect!"
            self.answerLabel["text"] = "The correct answer was " + str(answer)
            self.guessEntry["state"] = 'disabled'
            question7Score = 0
        elif guess == answer:
            self.correctAnswer["text"] = "That's right!"
            self.incorrectAnswer.destroy()
            self.answerLabel.destroy()
            self.guessEntry["state"] = 'disabled'
            question7Score = 200

    def quit(self):
        self.mainWindow.destroy()

    def mainMenu(self):
        self.mainWindow.destroy()
        TriviaGameMenu()

class TriviaGameQ8:
    def __init__(self):
        self.mainWindow = Tk()
        self.mainWindow.title("Texting Lingo, $400")

        # Title Label
        self.titleLabel = Label(self.mainWindow, text="Texting Lingo, $400", font="Times 25",
                                fg = "blue", justify=CENTER)
        self.titleLabel.grid(row=0, column=1)

        # Question Text
        self.QuestionText = Label(self.mainWindow, text="3 letters, used to indicate the first person's lack of interest.",
                                  font="Times 15", width = 50, justify=CENTER)
        self.QuestionText.grid(row=1, column=1, rowspan = 1)

        # Entry Box
        self.guessEntry = Entry(self.mainWindow, font="Arial 20", justify = CENTER, bd=10, width=5)
        self.guessEntry.grid(row=7, column=1)
        self.guessEntry.bind('<Return>', self.check)

        # Check Guess Button
        self.checkGuess = ttk.Button(self.mainWindow, text="Check Guess", command=self.check)
        self.checkGuess.grid(row=8, column=1)

        # Correct Answer
        self.correctAnswer = Label(self.mainWindow,
                                   text = "",
                                   fg = "green",
                                   justify=CENTER,
                                   font = "Times 20",
                                   padx=10,
                                   pady=10
                                   )
        self.correctAnswer.grid(row=2, column=1, rowspan=2)

        # Incorrect Answer
        self.incorrectAnswer = Label(self.mainWindow,
                                   text="",
                                   font = "Times 20",
                                   fg="red",
                                   justify=CENTER,
                                   padx=10
                                   )
        self.incorrectAnswer.grid(row=2, column=1)

        # Answer Label
        self.answerLabel = Label(self.mainWindow,
                               text="",
                               font="Times 20",
                               justify=CENTER,
                               padx=10
                               )
        self.answerLabel.grid(row=3, column=1, rowspan=2)

        # Back Button
        self.back = ttk.Button(self.mainWindow, text="Back", command=self.mainMenu)
        self.back.grid(row=9, column=0)


        # Quit Guess
        self.quitGuess = ttk.Button(self.mainWindow, text="Quit", command=self.quit)
        self.quitGuess.grid(row=9, column=2)


    def check(self, event = None):
        global question8Score
        guess = str(self.guessEntry.get())
        guess = guess.lower()
        answer = "idc"
        if guess != answer:
            self.correctAnswer.destroy()
            self.incorrectAnswer["text"] = "Incorrect!"
            self.answerLabel["text"] = "The correct answer was " + str(answer)
            self.guessEntry["state"] = 'disabled'
            question8Score = 0
        elif guess == answer:
            self.correctAnswer["text"] = "That's right!"
            self.incorrectAnswer.destroy()
            self.answerLabel.destroy()
            self.guessEntry["state"] = 'disabled'
            question8Score = 400

    def quit(self):
        self.mainWindow.destroy()

    def mainMenu(self):
        self.mainWindow.destroy()
        TriviaGameMenu()

class TriviaGameQ9:
    def __init__(self):
        self.mainWindow = Tk()
        self.mainWindow.title("Texting Lingo, $600")

        # Title Label
        self.titleLabel = Label(self.mainWindow, text="Texting Lingo, $600", font="Times 25",
                                fg = "blue", justify=CENTER)
        self.titleLabel.grid(row=0, column=1)

        # Question Text
        self.QuestionText = Label(self.mainWindow, text="4 letters, used to ask if another person understands\n the first person's intended sentiment.",
                                  font="Times 15", width = 50, justify=CENTER)
        self.QuestionText.grid(row=1, column=1, rowspan = 1)

        # Entry Box
        self.guessEntry = Entry(self.mainWindow, font="Arial 20", justify = CENTER, bd=10, width=5)
        self.guessEntry.grid(row=7, column=1)
        self.guessEntry.bind('<Return>', self.check)

        # Check Guess Button
        self.checkGuess = ttk.Button(self.mainWindow, text="Check Guess", command=self.check)
        self.checkGuess.grid(row=8, column=1)

        # Correct Answer
        self.correctAnswer = Label(self.mainWindow,
                                   text = "",
                                   fg = "green",
                                   justify=CENTER,
                                   font = "Times 20",
                                   padx=10,
                                   pady=10
                                   )
        self.correctAnswer.grid(row=2, column=1, rowspan=2)

        # Incorrect Answer
        self.incorrectAnswer = Label(self.mainWindow,
                                   text="",
                                   font = "Times 20",
                                   fg="red",
                                   justify=CENTER,
                                   padx=10
                                   )
        self.incorrectAnswer.grid(row=2, column=1)

        # Answer Label
        self.answerLabel = Label(self.mainWindow,
                               text="",
                               font="Times 20",
                               justify=CENTER,
                               padx=10
                               )
        self.answerLabel.grid(row=3, column=1, rowspan=2)

        # Back Button
        self.back = ttk.Button(self.mainWindow, text="Back", command=self.mainMenu)
        self.back.grid(row=9, column=0)


        # Quit Guess
        self.quitGuess = ttk.Button(self.mainWindow, text="Quit", command=self.quit)
        self.quitGuess.grid(row=9, column=2)


    def check(self, event = None):
        global question9Score
        guess = str(self.guessEntry.get())
        guess = guess.lower()
        answer = "kwim"
        if guess != answer:
            self.correctAnswer.destroy()
            self.incorrectAnswer["text"] = "Incorrect!"
            self.answerLabel["text"] = "The correct answer was " + str(answer)
            self.guessEntry["state"] = 'disabled'
            question9Score = 0
        elif guess == answer:
            self.correctAnswer["text"] = "That's right!"
            self.incorrectAnswer.destroy()
            self.answerLabel.destroy()
            self.guessEntry["state"] = 'disabled'
            question9Score = 600

    def quit(self):
        self.mainWindow.destroy()

    def mainMenu(self):
        self.mainWindow.destroy()
        TriviaGameMenu()

class chooseAmount:
    def __init__(self):
        self.mainWindow = Tk()
        self.mainWindow.title("Final Question")

        # Title Label
        self.titleLabel = Label(self.mainWindow, text="Final Question", font="Times 25",
                                fg="blue", justify=CENTER)
        self.titleLabel.grid(row=0, column=1)

        # Subtitle Label
        self.subtitleLabel = Label(self.mainWindow,
                                  text="Topic: Colors",
                                  font="Times 20", width=50, justify=CENTER)
        self.subtitleLabel.grid(row=1, column=1, rowspan=1)

        # Slider
        global score
        score = int(listSum)
        self.slider = Scale(from_=0, to=score, tickinterval=100, length=1000, orient=HORIZONTAL)
        self.slider.grid(row = 4, column = 1, rowspan = 2)

        # Set Button
        self.setScore = ttk.Button(self.mainWindow, text="Set Bet Amount", command=self.set)
        self.setScore.grid(row=6, column=1)

        # Final Score
        self.finalScoreLabel = Label(self.mainWindow,
                                     text="",
                                     font="Times 20",
                                     justify=CENTER,
                                     padx=10
                                     )
        self.finalScoreLabel.grid(row=10, column=1, rowspan=2)

        # Replay Button
        self.back = ttk.Button(self.mainWindow, text="Replay", command=self.mainMenu)
        self.back.grid(row=10, column=0)

        # Quit Guess
        self.quitGuess = ttk.Button(self.mainWindow, text="Quit", command=self.quit)
        self.quitGuess.grid(row=10, column=2)

    def check(self, event=None):
        guess = str(self.guessEntry.get())
        guess = guess.lower()
        answer = "yellow"
        # Correct Answer
        self.correctAnswer = Label(self.mainWindow,
                                   text="",
                                   fg="green",
                                   justify=CENTER,
                                   font="Times 20",
                                   padx=10,
                                   pady=10
                                   )
        self.correctAnswer.grid(row=2, column=1, rowspan=2)

        # Incorrect Answer
        self.incorrectAnswer = Label(self.mainWindow,
                                     text="",
                                     font="Times 20",
                                     fg="red",
                                     justify=CENTER,
                                     padx=10
                                     )
        self.incorrectAnswer.grid(row=2, column=1)

        # Answer Label
        self.answerLabel = Label(self.mainWindow,
                                 text="",
                                 font="Times 20",
                                 justify=CENTER,
                                 padx=10
                                 )
        self.answerLabel.grid(row=3, column=1, rowspan=2)

        if guess != answer:
            self.correctAnswer.destroy()
            self.incorrectAnswer["text"] = "Incorrect!"
            self.answerLabel["text"] = "The correct answer was " + str(answer)
            self.guessEntry["state"] = 'disabled'
            finalScore = str(score - betAmt)
            self.finalScoreLabel["text"] = "Your final score is $" + finalScore
        elif guess == answer:
            self.correctAnswer["text"] = "That's right!"
            self.incorrectAnswer.destroy()
            self.answerLabel.destroy()
            self.guessEntry["state"] = 'disabled'
            finalScore = str(score + betAmt)
            self.finalScoreLabel["text"] = "Your final score is $" + finalScore


    def set(self):
        global betAmt
        betAmt = int(self.slider.get())
        self.slider.destroy()
        self.setScore.destroy()
        self.subtitleLabel.destroy()

        # Question Text
        self.QuestionText = Label(self.mainWindow,
                                  text="In the RGB color system, this color is (255, 255, 0) and\n this color's hex code is ffff00. Name this color that,\n when added to orange, has a complement blue-violet.",
                                  font="Times 15", width=50, justify=CENTER)
        self.QuestionText.grid(row=1, column=1, rowspan=1)

        # Entry Box
        self.guessEntry = Entry(self.mainWindow, font="Arial 20", justify=CENTER, bd=10, width=5)
        self.guessEntry.grid(row=7, column=1)
        self.guessEntry.bind('<Return>', self.check)

        # Check Guess Button
        self.checkGuess = ttk.Button(self.mainWindow, text="Check Guess", command=self.check)
        self.checkGuess.grid(row=8, column=1)


    def quit(self):
        self.mainWindow.destroy()

    def mainMenu(self):
        self.mainWindow.destroy()
        global question1Score
        global question2Score
        global question3Score
        global question4Score
        global question5Score
        global question6Score
        global question7Score
        global question8Score
        global question9Score
        listVar = []
        listSum = 0
        num = 0
        score = 0
        try:
            question1Score
        except NameError:
            pass
        else:
            del question1Score
        try:
            question2Score
        except NameError:
            pass
        else:
            del question2Score
        try:
            question3Score
        except NameError:
            pass
        else:
            del question3Score
        try:
            question4Score
        except NameError:
            pass
        else:
            del question4Score
        try:
            question5Score
        except NameError:
            pass
        else:
            del question5Score
        try:
            question6Score
        except NameError:
            pass
        else:
            del question6Score
        try:
            question7Score
        except NameError:
            pass
        else:
            del question7Score
        try:
            question8Score
        except NameError:
            pass
        else:
            del question8Score
        try:
            question9Score
        except NameError:
            pass
        else:
            del question9Score
        TriviaGameMenu()

main()

