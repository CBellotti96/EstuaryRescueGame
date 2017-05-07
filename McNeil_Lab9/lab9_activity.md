xGit Intro Activity
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
    Emily McNeil (all by my lonesome)
    ```


D. Getting help
---------------

Run the following commands.

    git help
    git help -ag
    git help init

1.  What does `git help` do?

    ```
	Lists common git commands which are used in various situations, and briefly explains their use. Also tells you that you can elaborate (-a or -g tags) or make the search more specific by saying git help <command> or <concept>.

    ```

2.  What does `-ag` cause `git help` to do?

    ```
    Lists available git commands and commonly useful guides (attributes, everyday use, etc.) Wish I had known about this a year ago.

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
    Tells the user what files have been changed, which are staged for commit, and which files are tracked or not.
    ```

2.  What does `git add names.txt` do?

    ```
    Stages names.txt to be committed.
    ```

3.  What does `git commit -m "Add our names."` do?

    ```
    Commits the file locally with the message "Add our names."
    Still need to push to publish local commits.
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
    . means the current directory. Git add . adds all files in the current directory to be tracked.
    ```

5.  What does `git commit` (without -m) do?

    ```
    Opens a commit message window. 
    ```

6.  If you want to write a more detailed commit message (which is
    good practice) what command would you use?

    ```
    'git commit', without -m


    ```

7.  What does `git log do`?

    ```
    Shows all recent commit messages and codes.
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
    modified:   names.txt

    These files are in line to be committed.
    ```

    **Unstaged**
       modified:   .movies.txt.un~
       modified:   movies.txt
       modified:   ../src/edu/udel/cisc275/section011/team0/EstuaryGame/Controller/MazeController.java
       modified:   ../src/edu/udel/cisc275/section011/team0/EstuaryGame/Model/MazeMenuItem.java
       modified:   ../src/edu/udel/cisc275/section011/team0/EstuaryGame/Model/MazeWeather.java
       modified:   ../src/edu/udel/cisc275/section011/team0/EstuaryGame/Model/MenuItem.java
       modified:   ../src/edu/udel/cisc275/section011/team0/EstuaryGame/View/MazeView.java

       Modifications to these files have not been added to the current working branch.

    ```



    ```

    **Untracked**

    ```
       ../.names.txt.un~
       ../Final Images/Environment Misc/cloudyWeather.png
       ../Final Images/Environment Misc/rainyWeather.png
       ../Final Images/Environment Misc/sunnyWeather.png
       ../Final Images/Environment Misc/variableWeather.png
       .foods.txt.un~
       .names.txt.un~
       foods.txt
       movies.txt~
       names.txt~

       These files & their modifications are not being tracked by git.

    ```

1.  If you run `git commit` what changes will be committed (***DON’T DO IT***)?

    ```
    Only the changes to names.txt.
    ```

2.  What command do you run to stage changes?

    ```
    git add [. OR <filename>]
    ```

3.  What command do you run to unstage changes?

    ```
    git -rm OR git reset HEAD file


    ```

Run the following commands:

    git diff
    git diff --cached

1.  What does `git diff` display?

    ```
    Shows you what about a file has been edited.

    ```

2.  What does `git diff --cached` display?

    ```
    Different file versions available in git, between current state and last commit.
    ```

3.  Formulate a sequence of commands to unstage changes to `names.txt`,
    and stage the changes to `movies.txt`. Execute your commands and
    confirm they worked.

    ```
    names.txt deleted and movies.txt modified.
    ```

4.  Edit `movies.txt`, change any one of the movies, and save it. Then
    run `git status`. What do you observe? Explain what you think is
    going on.

    ```
    I think the most recent version of modifications on movies.txt have not been added.

    ```

5.  Delete `names.txt`. Then run `git status`. What do you observe?
    Explain what you think is going on.

    ```
    Whoops, just found out that the rm command DELETES (i.e. stages the removal from git), does not unstage. 

    ```

6.  Rename `movies.txt` to `last-movies`. Run `git status`. Observe
    and explain.

    ```
    Even though it's the same file with a different name, git does not automatically track the renamed file.

    ```

7.  Formulate a sequence of commands to stage all changes including the
    untracked file and commit (with any reasonable message you like).
    Execute them.

    ```



    ```

8.  In git vernacular, `index`, `cache`, and `stage` all refer to the
    same thing. What does it hold?

    ```
    Recent changes to tracked files, as well as identifying tracked from untracked.


    ```

9.  Why have a `stage`? Why not just commit all changes since the last
    commit?

    ```
    Some files are not ready to be pushed.


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
    Replaces all of the last commit to the stage.

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
    Resets to previous commit and unstages files.


    ```

2.  What is the difference between `--hard` and `--soft`?

    ```
    --hard is a hard reset with a clean slate,
    --soft sets you up to immediately restage files.

    ```

3.  What do you think `HEAD` means?

    ```
    Master branch.

    ```

4.  What do you think `HEAD^` means?

    ```
    Master branch commit immediately prior to current.

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
