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



    ```


D. Getting help
---------------

Run the following commands.

    git help
    git help -ag
    git help init

1.  What does `git help` do?

    ```
	Opens a basic guide detailing commonly used commands and the actions that they execute.

    ```

2.  What does `-ag` cause `git help` to do?

    ```
	Lists all git commands, without any explanation or guide on the actions that they execute.


    ```

G. Basic commands
-----------------

Open the terminal. Navigate to your team’s repository directory.

Create a directory inside of your team repository which will act as your submission directory for this lab.
The directory should be named according to the last names of your team members following the format below.

    <member1LastName>_<member2LastName>_Lab9

Use a plain text editor to create `names.txt` inside the directory you just created.
Put the names of your team in the file. Save and exit.

Run `git status` before and after each of these commands.

    git add names.txt
    git commit –m “Add our names.”
    git log

1.  What kind of information does `git status` report?

    ```
	The current branch, whether the branch is up to date, changes waiting to be committed, and untracked files.

    ```

2.  What does `git add names.txt` do?

    ```
	Stages names.txt to be committed to the working branch.
	
    ```

3.  What does `git commit -m "Add our names."` do?

    ```
	Commits names.txt to the branch without pushing to the github repo. Logs "Add our names." to identify the commit.

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
	Stages both text files to be committed to the working branch. the '.' signals to stage new and modified files (not deleted).

    ```

5.  What does `git commit` (without -m) do?

    ```
	Commits the files to the branch without pushing to the github repo. Opens a text editor to leave a log note for the commit.
	
    ```

6.  If you want to write a more detailed commit message (which is
    good practice) what command would you use?

    ```
	git commit without "-m" is better, as it opens a text editor to use instead of typing directly in the shell.

    ```

7.  What does `git log do`?

    ```
	git log lists all commits for the current branch along with their corresponding log messages.

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
	These are the files ready to be pushed to the github repo and published to the whole team.

    ```

    **Unstaged**

    ```
	movies.txt
	These files are being tracked by git, but have not been staged for publication.
	
    ```

    **Untracked**

    ```
	foods.txt
	These files are new files not currently tracked by git.

    ```

1.  If you run `git commit` what changes will be committed (***DON’T DO IT***)?

    ```
	names.txt will be committed to the local branch.

    ```

2.  What command do you run to stage changes?

    ```
	git add <file>

    ```

3.  What command do you run to unstage changes?

    ```
	git reset HEAD <file>

    ```

Run the following commands:

    git diff
    git diff --cached

1.  What does `git diff` display?

    ```
	The differences between the current commit and any modified files not staged for publication.

    ```

2.  What does `git diff --cached` display?

    ```
	The differences between the current commit and any modified files staged for publication.

    ```

3.  Formulate a sequence of commands to unstage changes to `names.txt`,
    and stage the changes to `movies.txt`. Execute your commands and
    confirm they worked.

    ```
	git reset HEAD names.txt
	git add movies.txt

    ```

4.  Edit `movies.txt`, change any one of the movies, and save it. Then
    run `git status`. What do you observe? Explain what you think is
    going on.

    ```
	There is a version of movies.txt that is staged for commit, and a version that is not staged for commit.
	Git is keeping a cached version of files that have been committed but not pushed.

    ```

5.  Delete `names.txt`. Then run `git status`. What do you observe?
    Explain what you think is going on.

    ```
	names.txt is marked as unstaged and deleted. names.txt will not be removed from the branch until the changes
	(in this case, the deletion) are staged and committed.

    ```

6.  Rename `movies.txt` to `last-movies`. Run `git status`. Observe
    and explain.

    ```
	movies.txt is marked as deleted and a new file, last-movies.txt is marked as untracked. Git does not recognize
	that it is the same file, instead, it treats a name change as a deletion followed by the addition of a new file.

    ```

7.  Formulate a sequence of commands to stage all changes including the
    untracked file and commit (with any reasonable message you like).
    Execute them.

    ```
	git add .
	git commit -m "Committing last-movies.txt and foods.txt"

    ```

8.  In git vernacular, `index`, `cache`, and `stage` all refer to the
    same thing. What does it hold?

    ```
	Files that are being tracked by git but have not been pushed to the repo.

    ```

9.  Why have a `stage`? Why not just commit all changes since the last
    commit?

    ```
	This makes it possible to be working on new files without affecting the current state of the project. This way,
	the project can go from working version to the next working version without broken versions in between.

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
	This undid the last commit made to the branch without changing the actual files.
	
    ```

Run the following commands:

    git commit –m "Redo."
    git log
    git status
    git reset --hard "HEAD^"
    git log
    git status

1.  What does `git reset --hard ``"HEAD^"`` `do?

    ```
	This reverted the status of the branch to the last commit by changing the associated files.

    ```

2.  What is the difference between `--hard` and `--soft`?

    ```
	--hard actually changes your files to match the last commit, while --soft just undoes the last commit.


    ```

3.  What do you think `HEAD` means?

    ```
	HEAD is a pointer to the current branch.

    ```

4.  What do you think `HEAD^` means?

    ```
	HEAD^ is a pointer to the commit before the current branch.

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
