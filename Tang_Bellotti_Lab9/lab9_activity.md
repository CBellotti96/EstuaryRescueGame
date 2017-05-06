Git Intro Activity
==================

A. Form teams
-------------

Form a 2-person team. Try to find someone who uses the same platform as you (e.g., Windows, Linux, etc.). If you can't, that's fine. If you are the odd-person-out, join a team of 2.

Complete the exercises below, and fill in your answers in the spaces provided below each question.
Once you have completed all the exercises and filled in this file with your answers, 
add this file to your Lab 9 directory (which you will create in section G) and push it to your team repo.
This file is the deliverable for this lab, so make sure you do not forget to push it at the end!

1.  List your team members below.
	
    ```
	Alvin Tang
	Chris Bellotti


    ```


D. Getting help
---------------

Run the following commands.

    git help
    git help -ag
    git help init

1.  What does `git help` do?

    ```
    git help provides a list of common git commands
    broken into relevant sections, and provides a 
    description of each
	

    ```

2.  What does `-ag` cause `git help` to do?

    ```
	-ag caused git help to privde a full list of
	subcommands on the path, as well as a lsit of common
	git guides, including a tutorial


    ```

G. Basic commands
-----------------

Open the terminal. Navigate to your team's repository directory.

Create a directory inside of your team repository which will act as your submission directory for this lab.
The directory should be named according to the last names of your team members following the format below.

    <member1LastName>_<member2LastName>_Lab9

Use a plain text editor to create `names.txt` inside the directory you just created.
Put the names of your team in the file. Save and exit.

Run `git status` before and after each of these commands.

    git add names.txt
    git commit -m "Add our names.txt"
    git log

1.  What kind of information does `git status` report?

    ```
    Lets you know the status of your local branch in relation to the github repository.

	```

2.  What does `git add names.txt` do?

    ```
	Add the file contents of names.txt to the index.


    ```

3.  What does `git commit -m "Add our names."` do?

    ```
	This will record changes to the repository with the message "Add our names"


    ```

Use a plain text editor to create the following files:

-   `birthdays.txt` - Put your birthdays in this file. (you are not obligated to use real information here)

-   `movies.txt` - Put the last movie each of you watched in alphabetical order.

Run `git status` before and after each of these commands.

    git add .
    git commit		Note:  Commit will open the vim editor; write a multi-line commit
						   message, save and quit (press esc and then type :wq).
    git log

4.  What does `git add .` do? What do you think `.` means?

    ```
	Adds the file contents of birthdays.txt and movies.txt to the index
	the '.' means all available files within the folder


    ```

5.  What does `git commit` (without -m) do?

    ```
	It will record changes to the repository and open the vim editor to ask you to write a message


    ```

6.  If you want to write a more detailed commit message (which is
    good practice) what command would you use?

    ```
	git commit (without -m) so you can use the vim editor.


    ```

7.  What does `git log do`?

    ```
	Lets you see all the previous messages others have entered when committing to the repository


    ```


H. Stage/Cache/Index
--------------------

Do the following:

-   Modify `names.txt` so that names are listed in *Last, First* format,
    one per line.

-   Modify `movies.txt` so they are in reverse alphabetical order
    by title.

-   Create a new file `foods.txt` that contains your favorite foods (one
    for each team member).

Run the following commands:

    git add names.txt
    git status

1.  Below write each file name under the state that its changes are
    currently in. Compose a definition for each state.

    **Staged**

    ```

	names.txt 
	
	local version match the version that has been indexed

    ```

    **Unstaged**

    ```

	movies.txt 
	
	Updated local version has not been indexed yet

    ```

    **Untracked**

    ```
	foods.txt

	Files in a directory that have not been added to the index
    ```

1.  If you run `git commit` what changes will be committed (***DON'T DO IT***)?

    ```
	names.txt will be committed 


    ```

2.  What command do you run to stage changes?

    ```
	git add


    ```

3.  What command do you run to unstage changes?

    ```

	git reset

    ```

Run the following commands:

    git diff
    git diff --cached

1.  What does `git diff` display?

    ```
	Shows changes between the working tree and the index


    ```

2.  What does `git diff --cached` display?

    ```
	Shows staged changes in the index against current Head


    ```

3.  Formulate a sequence of commands to unstage changes to `names.txt`,
    and stage the changes to `movies.txt`. Execute your commands and
    confirm they worked.

    ```
    git reset names.txt
	git add movies.txt

    ```

4.  Edit `movies.txt`, change any one of the movies, and save it. Then
    run `git status`. What do you observe? Explain what you think is
    going on.

    ```
	The most current version of movies.txt is not staged but the previous version is still in the index.


    ```

5.  Delete `names.txt`. Then run `git status`. What do you observe?
    Explain what you think is going on.

    ```
    It changed the status of names.txt from modifed to deleted because we deleted the file



    ```

6.  Rename `movies.txt` to `last-movies`. Run `git status`. Observe
    and explain.

    ```
	It lists movies.txt as deleted since it can no longer find it in the directory and list last-movies as a 	untracked file because it has not been added to the index.


    ```

7.  Formulate a sequence of commands to stage all changes including the
    untracked file and commit (with any reasonable message you like).
    Execute them.

    ```

	git add .
	git commit -m "Commit all changes"


    ```

8.  In git vernacular, `index`, `cache`, and `stage` all refer to the
    same thing. What does it hold?
    
    ```
		It lists all files in the current branch that are ready to be commited

    ```

9.  Why have a `stage`? Why not just commit all changes since the last
    commit?

    ```
	Allows you to split work into separate commits while not breaking the build.


    ```

I. Undo
-------

Run the following commands:

    git log
    git status
    git reset --soft "HEAD^"
    git log
    git status

1.  What does `git reset --soft ``"HEAD^" `do?

    ```
	It allows you to add more changes to the previous commit or change the commit message while leaving 	existing changes staged.


    ```

Run the following commands:

    git commit -m "Redo."
    git log
    git status
    git reset --hard "HEAD^"
    git log
    git status

1.  What does `git reset --hard ``"HEAD^"`` `do?

    ```
	changes the files in the working tree adn index the same as the version comminted in <Head^>


    ```

2.  What is the difference between `--hard` and `--soft`?

    ```
	--hard resets everything back to the previous version 
	--soft only resets the commit messages 


    ```

3.  What do you think `HEAD` means?

    ```
	Head is a reference to the current branch

    ```

4.  What do you think `HEAD^` means?

    ```
	means the first parent of the tip of the current branch.

    ```

J. Helpful resources
--------------------

-   <https://git-scm.com/doc>

-   <https://www.atlassian.com/git/tutorials/>

-   <https://training.github.com/kit/downloads/github-git-cheat-sheet.pdf>

K. Copyright and Licensing
--------------------------

Copyright 2016, Darci Burdge and Stoney Jackson SOME RIGHTS RESERVED

This work is licensed under the Creative Commons Attribution-ShareAlike
4.0 International License. To view a copy of this license, visit
<http://creativecommons.org/licenses/by-sa/4.0/> .
