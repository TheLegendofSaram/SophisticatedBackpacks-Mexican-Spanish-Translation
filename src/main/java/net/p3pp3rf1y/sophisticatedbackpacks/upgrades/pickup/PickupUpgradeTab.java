package net.p3pp3rf1y.sophisticatedbackpacks.upgrades.pickup;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.p3pp3rf1y.sophisticatedbackpacks.client.gui.BackpackScreen;
import net.p3pp3rf1y.sophisticatedbackpacks.client.gui.Dimension;
import net.p3pp3rf1y.sophisticatedbackpacks.client.gui.Position;
import net.p3pp3rf1y.sophisticatedbackpacks.client.gui.UpgradeSettingsTab;
import net.p3pp3rf1y.sophisticatedbackpacks.upgrades.FilterLogicControl;

import static net.p3pp3rf1y.sophisticatedbackpacks.client.gui.TranslationHelper.translUpgrade;
import static net.p3pp3rf1y.sophisticatedbackpacks.client.gui.TranslationHelper.translUpgradeTooltip;

@OnlyIn(Dist.CLIENT)
public class PickupUpgradeTab extends UpgradeSettingsTab<PickupUpgradeContainer> {
	protected PickupUpgradeTab(PickupUpgradeContainer upgradeContainer, Position position, Dimension openTabDimension, BackpackScreen screen, int slotsPerRow, ITextComponent tabLabel, ITextComponent closedTooltip) {
		super(upgradeContainer, position, openTabDimension, screen, slotsPerRow, tabLabel, closedTooltip);
	}

	public static class Basic extends PickupUpgradeTab {
		public Basic(PickupUpgradeContainer upgradeContainer, Position position, BackpackScreen screen) {
			super(upgradeContainer, position, new Dimension(63, 106), screen, 3,
					new TranslationTextComponent(translUpgrade("pickup")), new TranslationTextComponent(translUpgradeTooltip("pickup")));
			addHideableChild(new FilterLogicControl(new Position(x + 3, y + 24), getContainer()));
		}
	}

	public static class Advanced extends PickupUpgradeTab {
		public Advanced(PickupUpgradeContainer upgradeContainer, Position position, BackpackScreen screen) {
			super(upgradeContainer, position, new Dimension(81, 124), screen, 4,
					new TranslationTextComponent(translUpgrade("advanced_pickup")), new TranslationTextComponent(translUpgradeTooltip("advanced_pickup")));
			addHideableChild(new FilterLogicControl.Advanced(new Position(x + 3, y + 24), getContainer()));
		}
	}
}
