#[cfg(target_os = "android")]
fn cold_release() -> Result<(), String> {
    use std::{env, fs::create_dir_all, path::Path};

    use generate_message::{full_run, parser::Command};

    let manifest_dir = env::var_os("CARGO_MANIFEST_DIR").unwrap();
    let cold_release_dir = Path::new(&manifest_dir).join("../../android/src/main/assets/Database/");
    create_dir_all(&cold_release_dir).unwrap();
    let command = Command::MakeColdRelease {
        path: Some(cold_release_dir),
    };

    full_run(command).map_err(|e| format!("{}", e))?;

    Ok(())
}

#[cfg(not(target_os = "android"))]
///iOS db blobs generated in generate_database.sh script that runs during XCode build phase, not here yet
///other OS -> don't generate blobs
fn cold_release() -> Result<(), String> {
    Ok(())
}

fn main() -> Result<(), String> {
    println!("cargo:rerun-if-changed=./src/signer.udl");
    uniffi_build::generate_scaffolding("./src/signer.udl").unwrap();
    cold_release()
}
