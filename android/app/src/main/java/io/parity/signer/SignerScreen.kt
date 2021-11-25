package io.parity.signer

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import io.parity.signer.modals.*
import io.parity.signer.models.SignerDataModel
import io.parity.signer.screens.KeyManager
import io.parity.signer.screens.ScanScreen
import io.parity.signer.screens.SettingsScreen

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun ScreenSelector(screen: SignerScreen?, signerDataModel: SignerDataModel) {
	when (screen) {
		SignerScreen.Scan -> {
			ScanScreen(
				signerDataModel = signerDataModel
			)
		}
		SignerScreen.Keys -> {
			KeyManager(signerDataModel = signerDataModel)
		}
		SignerScreen.Settings -> {
			SettingsScreen(signerDataModel = signerDataModel)
		}
		SignerScreen.Log -> {
			HistoryScreen(signerDataModel = signerDataModel)
		}
		SignerScreen.LogDetails -> TODO()
		SignerScreen.Transaction -> {
			TransactionPreview(signerDataModel = signerDataModel)
		}
		SignerScreen.SeedSelector -> {
			SeedManager(signerDataModel = signerDataModel)
		}
		SignerScreen.KeyDetails -> {
			ExportPublicKey(signerDataModel = signerDataModel)
		}
		SignerScreen.Backup -> {
			SeedBackup(signerDataModel = signerDataModel)
		}
		SignerScreen.NewSeed -> {
			NewSeedModal(signerDataModel = signerDataModel)
		}
		SignerScreen.RecoverSeedName -> {
			NewSeedModal(signerDataModel = signerDataModel)
		}
		SignerScreen.RecoverSeedPhrase -> {
			NewSeedModal(signerDataModel = signerDataModel)
		}
		SignerScreen.DeriveKey -> {
			NewKeyModal(signerDataModel = signerDataModel, increment = false)
		}
		SignerScreen.Verifier -> TODO()
		SignerScreen.ManageNetwork -> TODO()
		null -> WaitingScreen()
	}
}

@Composable
fun ModalSelector(modal: SignerModal, signerDataModel: SignerDataModel) {
	when(modal) {
		SignerModal.None -> {}
		SignerModal.Error -> TODO()
		SignerModal.SeedDeleteConfirm -> TODO()
		SignerModal.KeyDeleteConfirm -> KeyDelete(signerDataModel = signerDataModel)
	}
}

/**
 * All screens metadata for navigation
 */
enum class SignerScreen {
	Log,
	LogDetails,
	Scan,
	Transaction,
	SeedSelector,
	Keys,
	KeyDetails,
	Backup,
	NewSeed,
	RecoverSeedName,
	RecoverSeedPhrase,
	DeriveKey,
	Settings,
	Verifier,
	ManageNetwork;
}

enum class TransactionState {
	None,
	Parsing,
	Preview,
	Password,
	Signed;
}

enum class SignerModal {
	None,
	Error,
	SeedDeleteConfirm,
	KeyDeleteConfirm;
}

enum class OnBoardingState {
	InProgress,
	No,
	Yes;
}

enum class SignerAlert {
	None,
	Active,
	Past
}
