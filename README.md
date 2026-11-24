# DBE Hyper Physics

A separate Forge 1.20.1 companion mod project for experimenting with DynamicBody Experience (DBE) physics settings.

## Target setup

- Minecraft 1.20.1
- Forge 47.x
- DynamicBody Experience 0.30.26
- Java 17

## Current status

This is the initial companion-mod scaffold. It registers a client config file at:

`config/dbe_hyper_physics-client.toml`

The config currently stores:
- Enable/disable switch
- Intensity (1–5; default 4)
- Movement response
- Damping

**Important:** These settings are not yet connected to DBE's internal spring simulation. That requires a verified compatibility hook against the exact DBE build. Do not treat this initial scaffold as a finished physics mod or installable release.

The original DBE JAR is not modified or redistributed by this repository.

## Build

Run:

```
gradle build
```

The output JAR will be in `build/libs/`.

## Next development step

Inspect the exact DBE 0.30.26 runtime behavior and implement a safe client-side integration. Test with the matching MinePreggo and Forge versions before publishing a release.
