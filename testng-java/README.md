# Java + TestNG + SpecSync

## What this example demonstrates

- TestNG test methods in Java.
- A SpecSync TestNG test-source plugin configuration placeholder.
- GitHub Actions running Maven, synchronizing tests, and publishing results.

**Licensing:** SpecSync's TestNG test-source integration is an Enterprise capability. Check the current package version and license with SpecSolutions.

## Project structure

```text
testng-java/
  .github/workflows/testng-specsync.yml
  .config/dotnet-tools.json
  pom.xml
  specsync.json
  src/test/java/example/LoginTest.java
```

## Configure

1. Replace `YOUR_ORG` and `YOUR_PROJECT` in `specsync.json`.
2. Configure the TestNG source plugin and source directory according to the current official TestNG integration guide.
3. Install the SpecSync CLI using the official installation instructions and commit the generated `.config/dotnet-tools.json`.
4. Add GitHub secret `ADO_SPECSYNC_PAT`.
5. Ensure a target Test Plan/Test Suite exists in ADO.

The plugin package shown in `specsync.json` is an example identifier. Verify the current package ID and version before use.

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
mvn test
dotnet tool restore
dotnet specsync push
```

Publish using the exact result-file path and format supported by your installed SpecSync release. The workflow below uses the documented `SurefireXml` format as a starting point.
