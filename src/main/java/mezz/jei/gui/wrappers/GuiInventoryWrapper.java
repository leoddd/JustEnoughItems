package mezz.jei.gui.wrappers;

import mezz.jei.gui.GuiContainerOverlay;
import mezz.jei.util.Reflection;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.inventory.ContainerPlayer;

public class GuiInventoryWrapper extends GuiInventory {
	private GuiContainerOverlay overlay;

	public GuiInventoryWrapper(GuiInventory gui) {
		super(Reflection.getPlayer((ContainerPlayer)gui.inventorySlots));
	}

	/* Overlay */
	@Override
	public void initGui() {
		super.initGui();
		overlay = new GuiContainerOverlay(guiLeft, xSize, width, height);
		overlay.initGui(buttonList);
	}

	@Override
	public void drawScreen(int xSize, int ySize, float var3) {
		super.drawScreen(xSize, ySize, var3);
		overlay.drawScreen(mc.getTextureManager(), fontRendererObj);
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		super.actionPerformed(button);
		overlay.actionPerformed(button);
	}

	@Override
	protected void mouseClicked(int xPos, int yPos, int mouseButton) {
		super.mouseClicked(xPos, yPos, mouseButton);
		overlay.mouseClicked(xPos, yPos, mouseButton);
	}

}