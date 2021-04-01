package ro.ase.acs.main;

import java.util.ArrayList;
import java.util.List;

import ro.ase.acs.prototype.BuildingBlock;
import ro.ase.acs.prototype.StoneBlock;
import ro.ase.acs.prototype.WoodBlock;

public class Main {

	public static void main(String[] args) {
		
		List<BuildingBlock> buildinBlocks=new ArrayList<>();
		StoneBlock stoneBlock = new StoneBlock();
		stoneBlock.setX(0);
		stoneBlock.setY(1);
		stoneBlock.setZ(0);
		
		
//		StoneBlock stoneBlock2 = new StoneBlock();
		StoneBlock stoneBlock2=null;
		try {
			stoneBlock2 = (StoneBlock) stoneBlock.clone();
			stoneBlock2.setX(1);
			stoneBlock2.setY(0);
			stoneBlock2.setZ(0);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		StoneBlock stoneBlock3=null;
		try {
			stoneBlock3 = (StoneBlock) stoneBlock.clone();
			stoneBlock3.setX(1);
			stoneBlock3.setY(0);
			stoneBlock3.setZ(1);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WoodBlock woodBlock = new WoodBlock();
		woodBlock.setX(1);
		woodBlock.setY(0);
		woodBlock.setZ(1);
		
		WoodBlock woodBlock2 =null;
		try {
			woodBlock2= (WoodBlock) woodBlock.clone();
			woodBlock2.setX(1);
			woodBlock2.setY(1);
			woodBlock2.setZ(1);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		buildinBlocks.add(stoneBlock);
		buildinBlocks.add(stoneBlock2);
		buildinBlocks.add(stoneBlock3);
		buildinBlocks.add(woodBlock);
		buildinBlocks.add(woodBlock2);
		
		
		for(BuildingBlock block : buildinBlocks) {
			block.render();
		}
		
		
	}

}
