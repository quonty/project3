package edu.blucrest.obed.assignment;

import android.content.Context;

import java.util.List;

import static java.lang.Math.abs;

public class Queen extends ChessPiece {
    public Queen(Context context, int id, int drawableId, float x, float y, char color) {
        super(context, id, drawableId, x, y, color);
    }

    protected Boolean isValidMove (List<List<ChessPiece>> currentBoard, int currentPlayer){
        ChessPiece targetPiece = currentBoard.get(snapYIndex).get(snapXIndex);

        if(!super.isValidMove(currentBoard, currentPlayer)){
            return false;
        }
        // Check for vertical movement
        else if(abs(rowIndex-snapYIndex)!=0 && abs(columnIndex-snapXIndex)==0) {
            for (int i= 1;i<abs(rowIndex-snapYIndex);i++){
                if (((rowIndex-snapYIndex)<0)&&(currentBoard.get(rowIndex+i).get(columnIndex))!=null){
                    setViolationCode(12);
                    return false;
                }
                else if(((rowIndex-snapYIndex)>0)&&(currentBoard.get(rowIndex-i).get(columnIndex))!=null){
                    setViolationCode(12);
                    return false;
                }
            }
            if(targetPiece != null){
                deletePieceInTarget = true;
                deletedPiece = targetPiece;
            }
            return true;
        }
        // Check for horizontal movement
        else if(abs(rowIndex-snapXIndex)==0 && abs(columnIndex-snapXIndex)!=0){
            for (int i= 1;i<abs(columnIndex-snapXIndex);i++){
                if (((columnIndex-snapXIndex)<0)&&(currentBoard.get(rowIndex).get(columnIndex+i))!=null){
                    setViolationCode(12);
                    return false;
                }
                else if(((columnIndex-snapXIndex)>0)&&(currentBoard.get(rowIndex).get(columnIndex-i))!=null){
                    setViolationCode(12);
                    return false;
                }
            }
            if(targetPiece != null){
                deletePieceInTarget = true;
                deletedPiece = targetPiece;
            }
            return true;
        }

        //check for diagonal
        else if(abs(rowIndex-snapYIndex) ==abs(columnIndex-snapXIndex)) {
            for (int i= 1;i<abs(rowIndex-snapYIndex);i++){
                if ((rowIndex-snapYIndex)<0 && (columnIndex-snapXIndex)<0 && currentBoard.get(rowIndex+i).get(columnIndex+i )!=null){  //right-bottom
                    setViolationCode(12);
                    return false;
                }else if ((rowIndex-snapYIndex)>0 && (columnIndex-snapXIndex)<0 && currentBoard.get(rowIndex-i).get(columnIndex+i )!=null) { //right-top
                    setViolationCode(12);
                    return false;
                }else if ((rowIndex-snapYIndex)>0 && (columnIndex-snapXIndex)>0 && currentBoard.get(rowIndex-i).get(columnIndex-i )!=null) { //left-top
                    setViolationCode(12);
                    return false;
                }else if ((rowIndex-snapYIndex)<0 && (columnIndex-snapXIndex)>0 && currentBoard.get(rowIndex+i).get(columnIndex-i )!=null) { //left-bottom
                    setViolationCode(12);
                    return false;
                }

            }
            if(targetPiece != null){
                deletePieceInTarget = true;
                deletedPiece = targetPiece;
            }
            return true;
        }
        else{
            setViolationCode(12);
            return false;
        }
    }

    protected void toKing(List<List<ChessPiece>> currentBoard){
        if (this.color=='w'){
            boolean up = true;
            boolean down = true;
            boolean right = true;
            boolean left = true;
            boolean upperleft = true;
            boolean upperright = true;
            boolean bottomleft = true;
            boolean bottomright = true;

            for (int i=1; i<8;i++){
                if (up && rowIndex-i>=0 && currentBoard.get(rowIndex-i).get(columnIndex) != null){
                    if (currentBoard.get(rowIndex-i).get(columnIndex).id == 4){
                        kingCaptured=true;
                        return;
                    }
                    else{
                        up = false;
                    }
                }
                if (right && columnIndex+i<8 && currentBoard.get(rowIndex).get(columnIndex+i) != null){
                    if (currentBoard.get(rowIndex).get(columnIndex+i).id == 4){
                        kingCaptured=true;
                        return;
                    }
                    else{
                        right = false;
                    }
                }
                if (down && rowIndex+i<8 && currentBoard.get(rowIndex+i).get(columnIndex) != null){
                    if (currentBoard.get(rowIndex+i).get(columnIndex).id == 4){
                        kingCaptured=true;
                        return;
                    }
                    else{
                        down = false;
                    }
                }
                if (left && columnIndex-i>=0 && currentBoard.get(rowIndex).get(columnIndex-i) != null){
                    if (currentBoard.get(rowIndex).get(columnIndex-i).id == 4){
                        kingCaptured=true;
                        return;
                    }
                    else{
                        left = false;
                    }
                }
                if (upperleft && rowIndex-i>=0 && columnIndex-i>=0 && currentBoard.get(rowIndex-i).get(columnIndex-i) != null){
                    if (currentBoard.get(rowIndex-i).get(columnIndex-i).id == 4){
                        kingCaptured=true;
                        return;
                    }
                    else{
                        upperleft = false;
                    }
                }
                if (bottomleft &&rowIndex+i<8 && columnIndex-i>=0 && currentBoard.get(rowIndex+i).get(columnIndex-i) != null){
                    if (currentBoard.get(rowIndex+i).get(columnIndex-i).id == 4){
                        kingCaptured=true;
                        return;
                    }
                    else{
                        bottomleft = false;
                    }
                }
                if (bottomright && rowIndex+i<8 && columnIndex+i<8 && currentBoard.get(rowIndex+i).get(columnIndex+i) != null){
                    if (currentBoard.get(rowIndex+i).get(columnIndex+i).id == 4){
                        kingCaptured=true;
                        return;
                    }
                    else{
                        bottomright = false;
                    }
                }
                if (upperright && rowIndex-i>=0 && columnIndex+i<8 && currentBoard.get(rowIndex-i).get(columnIndex+i) != null){
                    if (currentBoard.get(rowIndex-i).get(columnIndex+i).id == 4){
                        kingCaptured=true;
                        return;
                    }
                    else{
                        upperright = false;
                    }
                }

            }
        }
        if (this.color=='b'){
            boolean up = true;
            boolean down = true;
            boolean right = true;
            boolean left = true;
            boolean upperleft = true;
            boolean upperright = true;
            boolean bottomleft = true;
            boolean bottomright = true;

            for (int i=1; i<8;i++){
                if (up && rowIndex-i>=0 && currentBoard.get(rowIndex-i).get(columnIndex) != null){
                    if (currentBoard.get(rowIndex-i).get(columnIndex).id == 28){
                        kingCaptured=true;
                        return;
                    }
                    else{
                        up = false;
                    }
                }
                if (right && columnIndex+i<8 && currentBoard.get(rowIndex).get(columnIndex+i) != null){
                    if (currentBoard.get(rowIndex).get(columnIndex+i).id == 28){
                        kingCaptured=true;
                        return;
                    }
                    else{
                        right = false;
                    }
                }
                if (down && rowIndex+i<8 && currentBoard.get(rowIndex+i).get(columnIndex) != null){
                    if (currentBoard.get(rowIndex+i).get(columnIndex).id == 28){
                        kingCaptured=true;
                        return;
                    }
                    else{
                        down = false;
                    }
                }
                if (left && columnIndex-i>=0 && currentBoard.get(rowIndex).get(columnIndex-i) != null){
                    if (currentBoard.get(rowIndex).get(columnIndex-i).id == 28){
                        kingCaptured=true;
                        return;
                    }
                    else{
                        left = false;
                    }
                }
                if (upperleft && rowIndex-i>=0 && columnIndex-i>=0 && currentBoard.get(rowIndex-i).get(columnIndex-i) != null){
                    if (currentBoard.get(rowIndex-i).get(columnIndex-i).id == 28){
                        kingCaptured=true;
                        return;
                    }
                    else{
                        upperleft = false;
                    }
                }
                if (bottomleft &&rowIndex+i<8 && columnIndex-i>=0 && currentBoard.get(rowIndex+i).get(columnIndex-i) != null){
                    if (currentBoard.get(rowIndex+i).get(columnIndex-i).id == 28){
                        kingCaptured=true;
                        return;
                    }
                    else{
                        bottomleft = false;
                    }
                }
                if (bottomright && rowIndex+i<8 && columnIndex+i<8 && currentBoard.get(rowIndex+i).get(columnIndex+i) != null){
                    if (currentBoard.get(rowIndex+i).get(columnIndex+i).id == 28){
                        kingCaptured=true;
                        return;
                    }
                    else{
                        bottomright = false;
                    }
                }
                if (upperright && rowIndex-i>=0 && columnIndex+i<8 && currentBoard.get(rowIndex-i).get(columnIndex+i) != null){
                    if (currentBoard.get(rowIndex-i).get(columnIndex+i).id == 28){
                        kingCaptured=true;
                        return;
                    }
                    else{
                        upperright = false;
                    }
                }
            }
        }
    }
}
