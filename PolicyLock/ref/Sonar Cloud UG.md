**Sonar Cloud User Guide**
-------------------------------------------------------------------------------------
Install Sonar Cloud:
1. Navigate to https://sonarcloud.io/
2. Click on "GitHub" in "Analyze your repo" and Sign in
3. Click through and create organization if needed
4. Click Analyze new Project & Select Repository you want to Analyze
5. Select "Manually" under Analysis Method
6. Choose the programming language under what option best describes your build. (Support Languages: https://sonarcloud.io/documentation/advanced-setup/languages/overview/)
7. Choose your OS & Download the Files

Windows:
8. Follow instructions to add bin directory to the path environment variable(https://stackoverflow.com/questions/44272416/how-to-add-a-folder-to-path-environment-variable-in-windows-10-with-screensho)
9. Download or create "sonar-project.properties" file in the root folder of your repo (Refer: https://sonarcloud.io/documentation/advanced-setup/ci-based-analysis/sonarscanner/)
10. Execute the following from command prompt or terminal



Run Sonar Cloud Analysis:
1. Navigate to folder containing repository and project
2. Run Command: 
      - sonar-scanner.bat -D"sonar.organization=user" -D"sonar.projectKey=user_repoName"  -D"sonar.sources=." -D"sonar.host.url=https://sonarcloud.io"
       
3. Example: user= scallait, repoName = PolicyEnforcement
      - sonar-scanner.bat -D"sonar.organization=**scallait**" -D"sonar.projectKey=**scallait_PolicyEnforcement**"  -D"sonar.sources=." -D"sonar.host.url=https://sonarcloud.io"

