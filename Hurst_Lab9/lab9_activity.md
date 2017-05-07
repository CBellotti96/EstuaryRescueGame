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
    Alexandra Hurst
    ```

D. Getting help
---------------

Run the following commands.

    git help
    git help -ag
    git help init

1.  What does `git help` do?

    ```
    Running `git help` causes git to display general usage info and descriptions of commonly-used subcommands for different categories of action.
    ```

2.  What does `-ag` cause `git help` to do?

    ```
    Adding `-ag` to `git help` causes git to display, in addition to the aforementioned general usage info, all available git commands and common guides on how to use certain aspects of git.
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
    `git status` reports information on which branch is current, whether the current branch is up-to-date with or further ahead than the corresponding origin branch, which files are staged for commit (if any), which files are tracked but unstaged (if any), and which files are untracked (if any).  It also gives basic information about adding unstaged/untracked files, committing tracked files, and pushing the local repository to origin.
    ```

2.  What does `git add names.txt` do?

    ```
    Running `git add names.txt` "stages" names.txt, marking it to be committed.
    ```

3.  What does `git commit -m "Add our names."` do?

    ```
    Running `git commit -m "Add our names."` commits the staged names.txt file to the current branch of the local repository with the commit message "Add our names."  Committed changes are a (mostly) permanent part of the repository and are visible in the commit log (`git log`).
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
    `git add .` stages all uncommitted/untracked files in the current directory and subdirectories.  `.` refers to the current directory.
    ```

5.  What does `git commit` (without -m) do?

    ```
    `git commit` opens the user's default text editor to allow them to input a detailed, multi-line commit message, then commits the staged files with that message when the text editor is closed.
    ```

6.  If you want to write a more detailed commit message (which is
    good practice) what command would you use?

    ```
    `git commit` would be used, as it allows for longer, multi-line commit messages as opposed to `git commit -m`.
    ```

7.  What does `git log do`?

    ```
    `git log` displays a log of the commit history, including each commit's id, author, date, and message.
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
    Staged files are files that have had `git add` called on them and have not been modified since that point.
    ```

    **Unstaged**

    ```
    movies.txt
    Unstaged files are files that git knows about (have a previous version in the repository) that have been modified since the last commit but not added to the current commit.
    ```

    **Untracked**

    ```
    foods.txt
    Untracked files are files that git doesn't know about (have no previous version in the repository) but that are in the git repository directory or a subdirectory thereof.
    ```

1.  If you run `git commit` what changes will be committed (***DON’T DO IT***)?

    ```
    The changes to names.txt will be committed.
    ```

2.  What command do you run to stage changes?

    ```
    `git add <file>`
    ```

3.  What command do you run to unstage changes?

    ```
    `git reset <file>`
    ```

Run the following commands:

    git diff
    git diff --cached

1.  What does `git diff` display?

    ```
    `git diff` displays the changes (insertions and deletions) made to unstaged files since the last commit.
    ```

2.  What does `git diff --cached` display?

    ```
    `git diff --cached` displays the changes (insertions and deletions) made to staged files since the last commit.
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
    There appear to be two versions of the file: one staged and one unstaged.  The staged `movies.txt` is the one from before the latest modification, while the unstaged one is the one from after the modification.  The latest changes to `movies.txt` have not been staged yet.
    ```

5.  Delete `names.txt`. Then run `git status`. What do you observe?
    Explain what you think is going on.

    ```
    `names.txt` is still listed under unstaged changes, but it is marked as `deleted` instead of `modified`.  `names.txt` has been marked for deletion, but the delteion has not yet been committed.
    ```

6.  Rename `movies.txt` to `last-movies`. Run `git status`. Observe
    and explain.

    ```
    `movies.txt` is now listed as `deleted` under unstaged changes, while `last-movies` is listed as a new untracked file.  Git handles renamed files as a combined deletion of the file with the old name and creation of a file with the new name.
    ```

7.  Formulate a sequence of commands to stage all changes including the
    untracked file and commit (with any reasonable message you like).
    Execute them.

    ```
    git add .
    git commit -m "Changed name format to Last, First, renamed movies.txt to last-movies and changed the naming and ordering of the movies therein, and added foods.txt file containing favorite foods."
    ```

8.  In git vernacular, `index`, `cache`, and `stage` all refer to the
    same thing. What does it hold?

    ```
    It holds the changes to be committed.
    ```

9.  Why have a `stage`? Why not just commit all changes since the last
    commit?

    ```
    having a `stage` allows the developer to commit unrelated changes as seperate commits, even if many unrelated files have been modified.  First, the devloper stages one group of mutually-related changes for the first commit and writes an easily-understandable commit message, then proceeds to do the same for the second set of changes, and the third, etc.  This keeps the commit log clean and the changes reasonably-scoped.
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
    `git reset --soft "HEAD~"` resets HEAD (pointer to the last commit) to the previous commit without changing the index or working directory.  It is useful if one wishes to undo the last commit, perhaps due to a poor commit message or organization, but keep the actual changes to the local files so that they can be recommitted later on.
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
    `git reset --hard "HEAD~"` resets HEAD (pointer to the last commit) to the previous commit, resetting the index and working directory to the state they were in after that commit.  It is useful if one wishes to completely undo all changes made by the last commit.
    ```

2.  What is the difference between `--hard` and `--soft`?

    ```
    `--soft` causes `git reset` to update only which commit is pointed to by HEAD, leaving the index and working directory unchanged, while `--hard` causes `git reset` to update which commit is pointed to by HEAD and reset the working directory and index to the state they were in after that commit.
    ```

3.  What do you think `HEAD` means?

    ```
    `HEAD` is a pointer/alias to the latest commit. 
    ```

4.  What do you think `HEAD^` means?

    ```
    `HEAD~` is a pointer/alias to the commit prior to the latest commit. 
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
