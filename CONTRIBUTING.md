# Contribution Guidelines for Dragon Treasure Project
Welcome! These guidelines help keep our repository organized, maintain code quality, and make collaboration smooth.

"### Main Branches"
- **`main`**: The stable branch that always contains release-ready code. Code merged here should be fully tested and reviewed.
- **`develop`**: The main development branch where all feature branches are merged once complete. The latest code under development can be found here.

"### Feature Branches"
Each new feature or significant change should have its own branch off `develop`. 

**Naming Convention**: Use `feature/<feature-name>`. Example:
  - `feature/navigation-system`
**Purpose**: Feature branches are used to develop specific features, keeping them isolated from the main codebase.
**Merging**:  Once the feature is complete, open a pull request to `develop`. See below under "Reviewing and Merging" for more information as to how.

### Hotfix Branches
For critical fixes in `main` or in `develop`.
**Naming Convention**: Use `hotfix/<fix-description>`. Example:
  - `hotfix/player-name-bug`
**Purpose**: To fix bugs.
**Merging**: Hotfixes are merged into both `main` and `develop`.

## Pull Request Guidelines
### Opening a Pull Request
1. **Base Branch**: Feature branches should target `develop`, and hotfix branches should target `main`.
2. **Title**: Use a descriptive title that summarizes the feature or fix (e.g., "Add navigation system").
3. **Description**: Describe what the PR does, mentioning any new files, methods, or classes added. 

### Reviewing and Merging
- **Reviews**: no reviews necessary since we are a small team working in close tandem with each other. Make sure to merge together when unsure or to review code together firstly.
- **Merging**:
   - **Squash and Merge**: For feature branches to keep the commit history clean.
        - 1. Push feature branch to git, e.g. feature/navigation-system
        - 2. Go to GitHub repo, create a pull request (PR) for the feature branch you're on. Add title and comments and create the PR.
        - 3. Review the changes and at the bottom you'll see a Merge button with a dropdown arrow, press the arrow and select:
              "Squash and Merge" (all commits will be combined into one) 
        - 4. Edit the commit message to say something concise like "Implement navigation system". 
        - 5. Confirm Squash and Merge.
        - 7. Github will prompt to offer to delete the feature branch. Do not delete it as to keep commit tree since we don't have 
             professional testcases in this project.
        - 8. Rename feature branch by adding prefix "Committed" e.g. feature/Commited-navigation-system
   - **Merge Commit**: For release and hotfix branches to retain the full history.
        - 1. Push hotfix branch to git, e.g. hotfix/navigation-fix
        - 2. Create PR: base branch is for example develop or main. compare branch is the hotfix branch. Add title and description.
        - 3. From Merge dropdown menu, select "Create a merge commit".
        - 4. Confirm merge.
        - 5. Github will prompt to offer to delete the feature branch. Delete it to keep history clean in repo.
         
---

Following these guidelines will help us keep the project organized, ensure high code quality, and make it easier for everyone to collaborate. Thank you for your contribution!
