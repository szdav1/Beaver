# File Errors
> - In windows, before the name of the folder, "/" is required.
> - In Linux systems, when writing to a file, 
> if the "/" symbol is present  at the beggining of the name of the 
> folder, it won't find it.

`Conclusion: Make the folder/file names OS dependent.`

# Restart Error
> - In windows, the restart command works.
> - In Linux systems however, the commands are different.

`Conclusion: Make restart command OS dependent.`

### Overall Conclusion
> `A system that queries OS information and creates these strings depending on it should be made.`