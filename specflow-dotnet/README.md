# C# + SpecFlow + SpecSync

## Lifecycle note

SpecFlow is no longer actively maintained. For a new project, evaluate Reqnroll, its community-maintained successor, and confirm compatibility with your SpecSync version. This folder is a minimal SpecFlow-style starter for teams that already have a SpecFlow codebase.

## Project structure

```text
specflow-dotnet/
  .github/workflows/specflow-specsync.yml
  SpecFlow.SpecSync.Demo.csproj
  specsync.json
  Features/Login.feature
  Steps/LoginSteps.cs
```

## Configure

1. Replace the ADO organization and project placeholders in `specsync.json`.
2. Install the SpecSync CLI with the official installation method and commit the local .NET tool manifest.
3. Configure the SpecFlow source adapter/project settings required by your SpecSync release.
4. Add GitHub secret `ADO_SPECSYNC_PAT`.
5. Ensure the target ADO Test Plan/Test Suite exists.

The sample project package versions are illustrative; pin a mutually compatible SpecFlow, NUnit, .NET SDK, and SpecSync set for your repository.

## Install and pin the SpecSync CLI

Run these commands from this project folder using the official SpecSync installation instructions:

```bash
dotnet new tool-manifest
dotnet tool install SpecSync.AzureDevOps
dotnet tool restore
```

Commit the generated `.config/dotnet-tools.json` to Git. The GitHub Actions workflow runs `dotnet tool restore`, so this manifest must be present in the repository. If your licensed distribution uses a different package ID or feed, follow that distribution's installation instructions.

## Run locally

```bash
dotnet test
dotnet tool restore
dotnet specsync push
```

The GitHub workflow demonstrates the intended sequence. Confirm the exact SpecSync result format and CLI options against your installed release before relying on it in production.
