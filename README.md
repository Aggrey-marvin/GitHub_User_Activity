# GitHub_User_Activity
To get a users recent git hub activity based using their username 

# Program Flow
Parse command-line arguments
Validate username
    - make api call to GitHub 
Make API call to GitHub
    - make api call for events data
    - use EventFormatter to format data (Should be an attribute of GitHubApiClient)
Parse JSON response
Format events for display
Output to terminal

# Project URL
https://roadmap.sh/projects/github-user-activity