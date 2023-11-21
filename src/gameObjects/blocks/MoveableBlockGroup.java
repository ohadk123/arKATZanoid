import java.util.List;
import java.util.ArrayList;

public class MoveableBlockGroup {
    public ArrayList<MoveableBlock> blocks = new ArrayList<>();

    public MoveableBlockGroup(List<MoveableBlock> blocks) {
        this.blocks.addAll(blocks);
    }

    public void changeAllSpeed(double dx, double dy) {
        ArrayList<MoveableBlock> newBlocks = this.blocks;
        for (MoveableBlock moveableBlock : newBlocks) {
            moveableBlock.changeSpeed(dx, dy);
        }
        this.blocks = newBlocks;
    }
}
