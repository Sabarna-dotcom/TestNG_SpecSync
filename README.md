# SpecSync examples: TestNG and SpecFlow

This ZIP contains two separate reference implementations for synchronizing automated tests with Azure DevOps Test Plans using SpecSync, with GitHub Actions as the CI runner.

## Important distinction

- `testng-java/`: Java + TestNG + Selenium-style tests. Uses the SpecSync TestNG test-source plugin. The TestNG source integration is an Enterprise feature; confirm entitlement and compatible plugin version with SpecSolutions.
- `specflow-dotnet/`: C# + SpecFlow tests. SpecFlow is no longer actively maintained; for new projects, consider Reqnroll, its community-maintained successor. Check your SpecSync version's supported adapter and documentation before adopting.

These are starter templates, not a guaranteed drop-in production package. SpecSync CLI options, plugin versions, configuration schema and result format must be checked against the exact SpecSync release you install.

## Prerequisites

1. Azure DevOps organization/project and a Test Plan/Test Suite.
2. A PAT stored as GitHub repository secret `ADO_SPECSYNC_PAT`, with least-privilege Work Items and Test Management permissions required by SpecSync.
3. A local .NET tool manifest containing the SpecSync CLI (create it using the installation instructions for your licensed/versioned SpecSync distribution).
4. A compatible SpecSync license, including Enterprise entitlement for TestNG source synchronization.
5. Configure the project URL, suite, source paths, and credentials in each `specsync.json`.

Never commit PATs or other credentials.

## GitHub Actions

Each example has its own workflow under `.github/workflows/`. Copy the workflow into the repository you intend to use. Workflows are intentionally kept separate because TestNG is Java and SpecFlow is .NET.

The workflow sequence is:
1. Checkout source.
2. Set up the runtime.
3. Restore the SpecSync .NET tool.
4. `dotnet specsync push` to synchronize source tests.
5. Run the test suite.
6. Publish the generated test results to ADO.
7. Preserve a failing workflow status when tests fail.

## TestNG setup

See `testng-java/README.md`. The example includes a Maven TestNG project, a sample test class, an example SpecSync plugin configuration fragment, and GitHub Actions workflow.

The sample test uses a placeholder assertion. Replace it with your Selenium WebDriver setup and real application checks.

## SpecFlow setup

See `specflow-dotnet/README.md`. The example includes a .NET test project, a sample SpecFlow feature, step definitions, SpecSync configuration notes, and GitHub Actions workflow.

SpecFlow package versions can be constrained by your existing .NET runtime. Pin compatible versions rather than blindly using latest packages.

## Official references

- TestNG integration and Enterprise requirement: https://docs.specsolutions.eu/specsync/important-concepts/using-specsync-with-testng
- SpecFlow getting started and TRX publishing: https://docs.specsolutions.eu/specsync/getting-started/getting-started-specflow
- Supported result formats: https://docs.specsolutions.eu/specsync/reference/compatibility
- SpecSync CLI setup: https://docs.specsolutions.eu/specsync/installation/setup-and-configure

## Before running

- Validate the exact SpecSync config schema and plugin settings using the official documentation for your installed version.
- Confirm the exact CLI syntax and supported result format.
- Ensure the ADO Test Suite exists and the PAT can create/update test cases and publish test runs.
- For pull requests from forks, do not expose repository secrets. Restrict ADO synchronization/publication to trusted branches or trusted workflow events.
- Do not assume a GitHub Actions run automatically becomes an Azure Pipelines build. They are separate CI systems.
