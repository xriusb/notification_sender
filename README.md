This application loads a set of employee records from a flat file,
and sends a greetings email to all employees whose birthday is today.

The flat file is a sequence of records, separated by newlines. These
are the first few lines:

last_name, first_name, date_of_birth, email
Doe, John, 1982/10/08, john.doe@foobar.com
Ann, Mary, 1975/09/11, mary.ann@foobar.com

The greetings email will contain the following text:

Subject: Happy birthday!

Happy birthday, dear John!

To execute the program it needs to be provided by two arguments:

- File Path
- Date to check if any ones birthday




