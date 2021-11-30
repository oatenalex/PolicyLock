# PolicyLock
Desktop application for policy inofrmation and enforcement.

Under 4000 lines were analyzed by SonarCloud due to FXML files.
Additional, unavoidable CodeSmells due to JavaFX code structure.
MongoDB has requirements that cause unavoidable code smells.
  For example, all object fields must be public.
No loop testing was done due to testable loops not being present.
  All loops involve inconsistent application information.
  Applications are not replicable within our testing environment.

Some code smells were unavoidable too due to handling the file object.
Some handling of files would become ridiculously inefficient if refactored
like Sonar Cloud instructed. 
