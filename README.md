# PolicyEnforcement

Run Sonar Cloud Analysis:
1. Navigate to folder containing repository and project
2. Run Command: 
       sonar-scanner.bat -D"sonar.organization=user" -D"sonar.projectKey=user_repoName"  -D"sonar.sources=." -D"sonar.host.url=https://sonarcloud.io"
