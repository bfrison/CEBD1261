#!/usr/bin/python
import os
import sys

with open('/usr/local/apache2/htdocs/web.html', 'w') as f:
    print("<p>Hi, my name is %s, how are you doing today?</p>" % sys.argv[1], file=f)
os.execlp('httpd-foreground', 'httpd-foreground')
