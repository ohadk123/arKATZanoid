import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import biuoop.DrawSurface;

public class JojoApprochesDio implements LevelInformation {
    public static ArrayList<MoveableBlockGroup> moveableBlockGroups = new ArrayList<>();

    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocity() {
        return this.velocityDivider(this.numberOfBalls());
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 750;
    }

    @Override
    public String levelName() {
        return "Oh, you are approaching me?";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {
        Random rand = new Random(2);
            
            @Override
            public void drawOn(DrawSurface d) {
                // Background Background
                d.setColor(new Color(250, 238, 164));
                d.fillRectangle(0, 0, 800, 600);
                d.setColor(new Color(208, 143, 89));
                int space = rand.nextInt(20, 31);
                for (int y = space; y < d.getHeight() * 2; y += space) {
                    int numOfLines = rand.nextInt(2, 4);
                    space = rand.nextInt(10, 21);
                    for (int i = 1; i < numOfLines; i++) {
                        int startY = y + 5*i;
                        d.drawLine(0, startY, 3*startY, 0);
                    }
                }

                // Blue Fire Behind Dio
                int[] blueFireX = {148, 163, 163, 138, 124, 127, 127, 119, 20, 0, 0, 9, 9, 6, 0, 0, 5, 21, 17, 21, 15, 18, 5, 7, 19, 34, 119, 129, 140, 137, 231, 238, 238, 243, 259, 259, 265, 279, 286, 285, 296, 298, 306, 309, 314, 318, 319, 329, 335, 341, 349, 363, 384, 394, 396, 399, 415, 416, 412, 419, 424, 436, 436, 452, 454, 451, 455, 452, 431, 422, 439, 444, 444, 438, 440, 459, 464, 459, 477, 478, 475, 477, 483, 482};
                int[] blueFireY = {599, 582, 543, 556, 539, 557, 577, 599, 599, 544, 440, 435, 417, 414, 414, 373, 377, 367, 346, 333, 321, 310, 280, 259, 229, 232, 85, 71, 34, 0, 0, 17, 0, 0, 18, 39, 44, 44, 58, 40, 57, 81, 86, 82, 86, 105, 156, 171, 166, 175, 202, 217, 232, 249, 276, 235, 257, 286, 308, 315, 315, 332, 347, 371, 408, 424, 442, 474, 504, 546, 551, 545, 537, 533, 523, 539, 539, 509, 535, 546, 560, 568, 579, 599};
                drawPolygon(blueFireX, blueFireY, new Color(0, 255, 255), new Color(0, 200, 255), d);

                // Dio's Wrist
                for (int i = 5; i  >= 0; i--) {
                    if (i % 2 == 0) {
                        d.setColor(Color.BLACK);
                    } else {
                        d.setColor(new Color(230, 211, 132));
                    }
                    int x = 56, y = 505 - 10 * i, r = 17;
                    d.fillCircle(x, y, r);
                    d.drawCircle(x, y, r);
                }

                // Dio's Left Hand
                int[] dioLeftHandX = {73, 50, 48, 46, 45, 38, 40, 54, 62, 73, 85, 86, 91, 95, 95, 101, 101, 88, 77, 71};
                int[] dioLeftHandY = {599, 599, 592, 572, 564, 544, 505, 494, 494, 498, 510, 522, 543, 556, 574, 581, 587, 588, 594, 590};
                drawPolygon(dioLeftHandX, dioLeftHandY, new Color(255, 229, 165), d);

                int[] dioLeftHandInsideX = {51, 66, 56, 84, 64, 77, 40, 55, 84, 91, 46, 56, 63, 75, 47, 56, 65, 78, 87, 50, 59, 61, 70, 70, 81, 87, 88, 95, 88};
                int[] dioLeftHandInsideY = {501, 497, 512, 516, 533, 531, 549, 544, 551, 543, 569, 561, 559, 555, 585, 580, 577, 567, 562, 598, 593, 598, 593, 584, 576, 578, 573, 574, 587};
                Point[] p = new Point[dioLeftHandInsideX.length];
                for (int i = 0; i < p.length; i++) {
                    p[i] = new Point(dioLeftHandInsideX[i], dioLeftHandInsideY[i]);
                }
                Line[] dioLeftHandInsideLines = {new Line(p[0], p[4]),
                                                new Line(p[1], p[2]),
                                                new Line(p[6], p[7]),
                                                new Line(p[7], p[4]),
                                                new Line(p[4], p[5]),
                                                new Line(p[3], p[5]),
                                                new Line(p[5], p[8]),
                                                new Line(p[8], p[9]),
                                                new Line(p[7], p[15]),
                                                new Line(p[10], p[11]),
                                                new Line(p[11], p[8]),
                                                new Line(p[12], p[16]),
                                                new Line(p[14], p[15]),
                                                new Line(p[15], p[20]),
                                                new Line(p[15], p[16]),
                                                new Line(p[16], p[23]),
                                                new Line(p[16], p[17]),
                                                new Line(p[17], p[13]),
                                                new Line(p[17], p[18]),
                                                new Line(p[8], p[18]),
                                                new Line(p[18], p[26]),
                                                new Line(p[26], p[27]),
                                                new Line(p[28], p[25]),
                                                new Line(p[24], p[25]),
                                                new Line(p[23], p[24]),
                                                new Line(p[23], p[22]),
                                                new Line(p[21], p[22]),
                                                new Line(p[20], p[21]),
                                                new Line(p[20], p[19]),
                                                new Line(p[17], p[25]),
                                                new Line(p[25], p[27])};
                drawLines(dioLeftHandInsideLines, d);

                // Dio's Inside Upper Shirt
                d.setColor(new Color(216, 168, 84));
                d.fillRectangle(94, 229, 34, 121);
                d.setColor(Color.BLACK);
                d.drawRectangle(94, 229, 34, 121);
                
                d.setColor(new Color(228, 211, 133));
                d.fillRectangle(182, 121, 18, 40);
                d.setColor(Color.BLACK);
                d.drawRectangle(182, 121, 18, 40);

                // Dio's Arm
                int[] dioArmX = {38, 25, 29, 23, 25, 36, 39, 34, 33, 92, 89, 133, 108, 103, 102, 109, 105, 97, 79, 79, 88, 87, 79, 73, 72, 69, 60, 54, 45, 40};
                int[] dioArmY = {475, 467, 440, 431, 410, 376, 356, 332, 307, 243, 210, 168, 206, 226, 246, 267, 303, 348, 431, 444, 457, 468, 480, 477, 457, 455, 464, 464, 452, 456};
                drawPolygon(dioArmX, dioArmY, new Color(253, 227, 104), d);

                Line[] dioArmLines = {new Line(30, 469, 35, 460),
                                    new Line(52, 461, 35, 441),
                                    new Line(53, 459, 57, 436),
                                    new Line(53, 459, 64, 439),
                                    new Line(81, 463, 76, 451),
                                    new Line(79, 430, 64, 363),
                                    new Line(51, 422, 34, 388),
                                    new Line(51, 422, 49, 339),
                                    new Line(49, 339, 35, 311),
                                    new Line(90, 378, 62, 331),
                                    new Line(62, 331, 62, 299),
                                    new Line(96, 340, 76, 323),
                                    new Line(102, 319, 92, 303),
                                    new Line(104, 289, 90, 260),
                                    new Line(106, 274, 92, 257),
                                    new Line(88, 252, 100, 238)};
                drawLines(dioArmLines, d);

                int[] dioUpperShirtX = {128, 109, 103, 103, 108, 116, 132, 159, 187, 216, 207, 202, 203, 200, 197, 183, 192};
                int[] dioUpperShirtY = {235, 274, 246, 224, 207, 193, 171, 121, 84, 64, 78, 99, 155, 155, 124, 125, 153};
                drawPolygon(dioUpperShirtX, dioUpperShirtY, new Color(249, 229, 94), d);

                // Dio's Mid Shirt
                d.setColor(new Color(216, 168, 84));
                d.fillCircle(201, 210, 55);
                d.setColor(Color.BLACK);
                d.drawCircle(201, 210, 55);

                d.setColor(Color.BLACK);
                d.fillRectangle(152, 336, 52, 137);
                int[] littleBlackTriangleX = {165, 169, 175};
                int[] littleBlackTriangleY = {472, 486, 472};
                drawPolygon(littleBlackTriangleX, littleBlackTriangleY, Color.BLACK, d);

                int[] littleGreenTriangleX = {168, 164, 182, 176};
                int[] littleGreenTriangleY = {362, 384, 362, 347};
                drawPolygon(littleGreenTriangleX, littleGreenTriangleY, new Color(169, 196, 89), d);

                // Dio's Lower Shirt
                int[] dioLowerShirtX = {151, 141, 125, 87, 79, 79, 97, 117, 124, 128, 139, 156, 165, 184, 205, 205, 194, 188, 188, 176, 151, 131, 115, 103, 93, 88, 88, 91, 117, 137, 151};
                int[] dioLowerShirtY = {461, 457, 454, 456, 444, 430, 353, 297, 271, 237, 217, 196, 185, 172, 170, 183, 207, 217, 230, 235, 257, 292, 321, 360, 407, 432, 446, 450, 449, 450, 457};
                drawPolygon(dioLowerShirtX, dioLowerShirtY, new Color(255, 224, 95), d);

                Line[] dioLowerShirtLines = {new Line(130, 286, 150, 256),
                                            new Line(158, 239, 166, 228),
                                            new Line(166, 228, 168, 209),
                                            new Line(168, 209, 160, 194)};
                drawLines(dioLowerShirtLines, d);

                // Dio Inside Lower Shirt
                // int[] dioInsideLowerShirtX = {205, 202, 188, 188, 228, 219, 213, 211, 210, 207, 203};
                // int[] dioInsideLowerShirtY = {171, 193, 215, 226, 226, 208, 190, 178, 171, 167, 153};

                // Dio Black Inner Shirt
                int[] dioInsideShirtX = {160, 149, 143, 143, 116, 115, 120, 150, 178, 205, 233, 265, 296, 314, 314, 286, 281, 257, 244, 225, 207, 196, 189, 183, 174, 164};
                int[] dioInsideShirtY = {402, 398, 388, 372, 364, 330, 314, 257, 233, 230, 234, 288, 332, 352, 356, 340, 323, 310, 304, 304, 319, 335, 353, 362, 345, 377};
                drawPolygon(dioInsideShirtX, dioInsideShirtY, Color.BLACK, d);

                // Dio's Belt
                d.setColor(new Color(169, 196, 89));
                d.fillRectangle(272, 309, 7, 13);
                d.fillRectangle(261, 302, 7, 12);
                d.fillRectangle(246, 297, 9, 14);
                d.fillRectangle(236, 296, 4, 8);
                d.fillRectangle(223, 295, 9, 11);
                d.fillRectangle(212, 296, 8, 14);
                d.fillRectangle(197, 305, 7, 20);
                d.fillRectangle(187, 317, 6, 30);
                d.fillRectangle(179, 333, 5, 27);

                // Dio Right Arm
                int[] dioRightArmX = {222, 216, 207, 202, 204, 211, 214, 230, 248, 270, 287, 287, 297, 307, 323, 338, 356, 364, 370, 379, 384, 393, 402, 414, 414, 410, 406, 402, 358, 350, 342, 335, 331, 325, 321, 314, 310, 306, 301, 296, 294, 295, 292, 287, 285, 279, 269, 264, 257, 251};
                int[] dioRightArmY = {59, 63, 78, 99, 153, 173, 194, 227, 261, 295, 318, 323, 336, 348, 361, 386, 400, 409, 415, 415, 403, 410, 410, 390, 366, 356, 352, 331, 291, 256, 239, 229, 221, 215, 209, 204, 204, 197, 170, 164, 160, 144, 136, 133, 119, 105, 84, 72, 63, 59};
                drawPolygon(dioRightArmX, dioRightArmY, new Color(255, 221, 97), d);

                // Dio Right Arm Lines
                Line[] dioRightArmLines = {new Line(325, 347, 340, 384),
                                        new Line(340, 384, 342, 390),
                                        new Line(350, 395, 374, 406),
                                        new Line(377, 397, 384, 402),
                                        new Line(406, 400, 383, 386),
                                        new Line(383, 386, 324, 311),
                                        new Line(324, 311, 300, 314),
                                        new Line(300, 314, 289, 300),
                                        new Line(289, 300, 268, 293),
                                        new Line(325, 310, 323, 280),
                                        new Line(323, 280, 312, 247),
                                        new Line(326, 248, 325, 230),
                                        new Line(332, 251, 333, 230),
                                        new Line(340, 253, 339, 237),
                                        new Line(266, 290, 286, 273),
                                        new Line(263, 283, 286, 268),
                                        new Line(256, 275, 286, 263),
                                        new Line(251, 265, 284, 256),
                                        new Line(246, 259, 280, 252),
                                        new Line(233, 231, 228, 208),
                                        new Line(228, 208, 232, 152),
                                        new Line(317, 219, 305, 216),
                                        new Line(305, 216, 304, 201),
                                        new Line(289, 166, 278, 158),
                                        new Line(278, 158, 270, 148),
                                        new Line(270, 148, 266, 134),
                                        new Line(295, 164, 286, 158),
                                        new Line(286, 158, 287, 134)};
                drawLines(dioRightArmLines, d);

                // Dio's Legs
                int[] dioLegsX = {205, 203, 197, 194, 204, 169, 180, 189, 183, 196, 208, 221, 231, 244, 268, 284, 310, 314, 324, 356, 387, 407, 411, 266, 253, 214};
                int[] dioLegsY = {595, 577, 569, 550, 524, 486, 444, 425, 361, 329, 314, 307, 303, 305, 316, 326, 360, 399, 419, 458, 509, 567, 599, 599, 588, 585};
                drawPolygon(dioLegsX, dioLegsY, new Color(254, 231, 111), d);

                Line[] dioLegLines = {new Line(218, 583, 246, 566), 
                                    new Line(249, 565, 269, 558), 
                                    new Line(268, 558, 279, 559), 
                                    new Line(279, 559, 299, 578), 
                                    new Line(210, 579, 254, 534), 
                                    new Line(201, 573, 204, 561), 
                                    new Line(214, 553, 245, 525), 
                                    new Line(201, 540, 211, 532), 
                                    new Line(212, 530, 217, 503), 
                                    new Line(201, 503, 210, 497), 
                                    new Line(214, 534, 231, 519), 
                                    new Line(231, 519, 268, 497), 
                                    new Line(268, 497, 276, 485), 
                                    new Line(223, 524, 246, 490), 
                                    new Line(233, 516, 257, 480), 
                                    new Line(247, 508, 262, 485), 
                                    new Line(259, 501, 270, 485), 
                                    new Line(206, 493, 221, 484), 
                                    new Line(204, 489, 214, 479), 
                                    new Line(215, 479, 232, 470), 
                                    new Line(232, 470, 272, 459), 
                                    new Line(181, 497, 192, 480), 
                                    new Line(200, 482, 188, 471), 
                                    new Line(185, 470, 203, 445), 
                                    new Line(226, 457, 266, 443), 
                                    new Line(288, 522, 271, 536), 
                                    new Line(271, 536, 271, 541), 
                                    new Line(279, 541, 306, 529),
                                    new Line(301, 558, 307, 544), 
                                    new Line(299, 499, 317, 510), 
                                    new Line(311, 443, 307, 527), 
                                    new Line(307, 350, 306, 599), 
                                    new Line(331, 475, 353, 531), 
                                    new Line(334, 488, 330, 510), 
                                    new Line(344, 512, 339, 530), 
                                    new Line(369, 519, 357, 535), 
                                    new Line(356, 535, 376, 551), 
                                    new Line(354, 535, 353, 539), 
                                    new Line(353, 539, 344, 578), 
                                    new Line(376, 551, 356, 535), 
                                    new Line(382, 552, 396, 564), 
                                    new Line(409, 587, 396, 564), 
                                    new Line(389, 560, 389, 578), 
                                    new Line(389, 577, 382, 598),
                                    new Line(250, 402, 275, 389), 
                                    new Line(277, 386, 257, 387), 
                                    new Line(237, 402, 257, 387), 
                                    new Line(205, 377, 237, 402), 
                                    new Line(205, 377, 201, 362), 
                                    new Line(201, 362, 191, 348), 
                                    new Line(289, 384, 282, 362), 
                                    new Line(232, 369, 292, 361), 
                                    new Line(268, 369, 292, 361), 
                                    new Line(278, 359, 255, 347), 
                                    new Line(253, 348, 210, 358), 
                                    new Line(210, 353, 223, 345), 
                                    new Line(229, 339, 246, 330), 
                                    new Line(240, 306, 251, 348), 
                                    new Line(255, 347, 278, 359), 
                                    new Line(293, 352, 275, 339), 
                                    new Line(274, 326, 290, 346) 
                                    };
                drawLines(dioLegLines, d);

                // Dio Inside Outer Shirt
                int[] dioInsideOutShirtX = {151, 159, 160, 157, 149, 143, 143, 119, 117, 103, 93, 88, 88, 91, 117, 137};
                int[] dioInsideOutShirtY = {456, 437, 401, 399, 397, 388, 370, 364, 319, 359, 406, 432, 447, 450, 449, 450};
                drawPolygon(dioInsideOutShirtX, dioInsideOutShirtY, new Color(161, 170, 175), d);

                Line[] dioInsideOutShirtLines = {new Line(97, 447, 102, 436),
                                                new Line(103, 432, 109, 357),
                                                new Line(115, 429, 116, 373),
                                                new Line(117, 375, 125, 403),
                                                new Line(130, 370, 134, 404),
                                                new Line(130, 442, 133, 422),
                                                new Line(139, 439, 147, 400)};
                drawLines(dioInsideOutShirtLines, d);

                // Dio's Green Something
                int[] dioGreenThingX = {209, 231, 263, 285, 295, 298, 314, 314, 304, 286, 285, 285, 298, 302, 303, 307, 306, 301, 281, 240, 220, 208, 201, 189, 184, 179, 176, 171, 172, 177, 199};
                int[] dioGreenThingY = {439, 434, 425, 416, 407, 406, 393, 356, 350, 327, 328, 341, 350, 350, 358, 364, 372, 382, 394, 406, 410, 410, 405, 391, 364, 359, 360, 369, 387, 408, 436};
                drawPolygon(dioGreenThingX, dioGreenThingY, new Color(169, 196, 89), d);

                d.setColor(new Color(169, 196, 89));
                d.fillOval(175, 363, 7, 17);
                d.fillOval(171, 359, 15, 26);
                d.setColor(Color.BLACK);
                d.drawOval(175, 363, 7, 17);
                d.drawOval(171, 359, 15, 26);
                
                int[] dioLeftGreenThingX = {167, 162, 160, 159, 136, 148, 153, 158, 164, 174, 182, 170, 162, 159, 159, 174, 177, 175, 173, 172};
                int[] dioLeftGreenThingY = {386, 401, 410, 438, 494, 504, 510, 520, 518, 510, 500, 487, 496, 496, 487, 439, 422, 408, 389, 386};
                drawPolygon(dioLeftGreenThingX, dioLeftGreenThingY, new Color(169, 196, 89), d);
                
                int[] dioLeftGreenCircleX = {165, 165, 168, 170, 170};
                int[] dioLeftGreenCircleY = {413, 398, 395, 398, 405};
                d.drawPolygon(new Polygon(dioLeftGreenCircleX, dioLeftGreenCircleY, dioLeftGreenCircleX.length));

                // Dio's Hair
                int[] dioHairX = {156, 163, 164, 167, 166, 175, 176, 179, 184, 193, 196, 187, 198, 204, 207, 211, 224, 223, 221, 219, 213, 208, 213, 214, 212, 210, 200, 194, 187, 183, 175, 171, 158};
                int[] dioHairY = {110, 131, 114, 108, 131, 103, 122, 120, 97, 81, 80, 103, 81, 80, 72, 70, 56, 54, 54, 42, 34, 32, 39, 55, 55, 53, 53, 57, 70, 75, 77, 85, 88};
                drawPolygon(dioHairX, dioHairY, new Color(249, 250, 97), d);

                Line[] dioHairLines = {new Line(164, 121, 163, 99),
                                    new Line(163, 99, 171, 85),
                                    new Line(171, 85, 166, 107),
                                    new Line(175, 104, 182, 76),
                                    new Line(197, 101, 205, 77),
                                    new Line(210, 71, 197, 64),
                                    new Line(207, 62, 200, 54),
                                    new Line(209, 59, 205, 52)};
                drawLines(dioHairLines, d);

                // Dio Right Hand
                int[] dioRightHandX = {403, 402, 413, 412, 406, 406, 411, 417, 425, 431, 434, 434, 430, 428, 424, 421};
                int[] dioRightHandY = {418, 446, 463, 481, 482, 487, 489, 484, 484, 472, 448, 436, 430, 399, 391, 391};
                drawPolygon(dioRightHandX, dioRightHandY, new Color(248, 234, 195), d);

                Line[] dioHandLines = {new Line(410, 485, 411, 481),
                                    new Line(417, 483, 421, 475),
                                    new Line(421, 475, 422, 456),
                                    new Line(427, 458, 429, 475),
                                    new Line(433, 467, 430, 454),
                                    new Line(421, 439, 413, 415),
                                    new Line(427, 429, 419, 409)};
                drawLines(dioHandLines, d);

                // Dio's Right Wrist
                int[] dioWristX = {401, 403, 411, 420, 421, 418, 414, 414};
                int[] dioWristY = {409, 418, 411, 405, 393, 388, 387, 391};
                drawPolygon(dioWristX, dioWristY, new Color(230, 211, 132), d);

                Line[] dioWristLines = {new Line(403, 417, 412, 404), new Line(403, 408, 410, 401),
                                        new Line(403, 418, 412, 405), new Line(403, 409, 410, 402)};
                drawLines(dioWristLines, d);

                // Dio's Left Shoe
                int[] dioLeftShoeX = {204, 266, 254, 214, 205};
                int[] dioLeftShoeY = {599, 599, 588, 585, 595};
                drawPolygon(dioLeftShoeX, dioLeftShoeY, new Color(175, 211, 75), d);

                // Dio's Right Shoe
                int[] dioRightShoeX = {411, 438, 434, 430, 425, 420, 407};
                int[] dioRightShoeY = {599, 599, 583, 580, 570, 566, 565};
                drawPolygon(dioRightShoeX, dioRightShoeY, new Color(175, 211, 75), d);

                // Dio's Silhouette
                int[] dioSilhouetteX = {208, 223, 229, 246, 294, 310, 313, 321, 325, 326, 324, 317, 320, 326, 330, 327, 320, 315, 309, 302, 286, 258, 238, 216};
                int[] dioSilhouetteY = {440, 456, 456, 441, 416, 416, 429, 447, 473, 491, 563, 599, 599, 563, 484, 443, 417, 406, 404, 404, 415, 427, 433, 438};
                drawPolygon(dioSilhouetteX, dioSilhouetteY, Color.BLACK, d);

                // Jojo Background
                int[] jojoBackground = {549, 600, 523, 549, 526, 524, 512, 484, 519, 470, 511, 443, 518, 420, 499, 397, 505, 381, 505, 356, 500, 332, 504, 306, 493, 296, 490, 287, 510, 264, 485, 240, 523, 201, 578, 180, 613, 219, 637, 240, 672, 276, 686, 308, 689, 356, 677, 411, 696, 447, 694, 468, 721, 481, 750, 493, 751, 519, 740, 539, 742, 567, 752, 600};
                drawSeperatedPolygon(jojoBackground, new Color(255, 255, 200), new Color(250, 233, 164), d);

                Line[] jojoBackgroundLines = {makeLeftLine(545, 539, 42, 61),
                                            makeLeftLine(528, 488, 77, 112),
                                            makeLeftLine(513, 422, 107, 178),
                                            makeLeftLine(506, 370, 120, 230),
                                            makeLeftLine(654, 390, 3, 54),
                                            makeLeftLine(676, 414, 1, 87),
                                            makeLeftLine(693, 435, 8, 165),
                                            makeRightLine(713, 440, 4, 68),
                                            makeLeftLine(504, 296, 35, 72),
                                            makeLeftLine(507, 227, 26, 70),
                                            makeLeftLine(531, 213, 7, 19),
                                            makeLeftLine(549, 200, 10, 34),
                                            makeLeftLine(568, 185, 14, 56),
                                            makeLeftLine(588, 192, 9, 45),
                                            makeLeftLine(615, 224, 2, 38),
                                            makeLeftLine(630, 247, 5, 40),
                                            makeLeftLine(661, 288, 1, 31),
                                            makeLeftLine(640, 194, 11, 108)};
                drawLine(jojoBackgroundLines, Color.CYAN, d);

                // Jojo's Hat
                int[] JojoHat = {543, 262, 540, 262, 533, 253, 533, 245, 538, 240, 541, 239, 539, 236, 539, 229, 542, 226, 550, 226, 563, 230, 568, 237};
                drawSeperatedPolygon(JojoHat, new Color(10, 19, 94), d);

                // Jojo's Face
                int[] jojoFace = {550, 284, 555, 281, 568, 247, 568, 238, 565, 236, 556, 238, 548, 244, 544, 250, 544, 259, 545, 271};
                drawSeperatedPolygon(jojoFace, new Color(234, 220, 175), d);

                // Jojo's Nose
                int[] jojoNose = {548, 250, 553, 253, 551, 247};
                drawSeperatedPolygon(jojoNose, new Color(195, 171, 133), new Color(129, 99, 65), d);
                d.drawLine(545, 257, 546, 251);
                d.drawLine(551, 262, 554, 258);
                d.drawLine(554, 258, 558, 258);
                d.drawLine(545, 251, 554, 242);

                // Jojo First Chain Loop
                Color chainColor = new Color(217, 217, 153);
                Color chainOuterColor = chainColor.darker();
                d.setColor(chainOuterColor);
                d.fillOval(568, 236, 13, 25);
                d.setColor(chainColor);
                d.fillOval(569, 237, 11, 23);
                d.setColor(chainOuterColor);
                d.drawOval(570, 241, 8, 20);
                
                // Jojo's hat lining
                int[] jojoHatLining = {545, 237, 559, 238, 558, 233, 554, 231, 538, 234, 533, 238, 531, 243, 532, 244, 536, 242, 538, 239};
                drawSeperatedPolygon(jojoHatLining, new Color(131, 116, 83), d);

                // Jojo's Right Wrist
                int[] jojoWrist = {545, 518, 551, 528, 562, 527, 559, 517};
                drawSeperatedPolygon(jojoWrist, new Color(200, 200, 200), d);

                // Jojo's Legs and Hand
                int[] jojoLegsHand = {541, 426, 544, 429, 544, 435, 540, 446, 540, 452, 543, 458, 541, 513, 544, 517, 549, 520, 555, 522, 561, 521, 562, 519, 560, 499, 560, 491, 564, 482, 567, 483, 575, 537, 580, 561, 582, 563, 585, 580, 594, 592, 595, 599, 711, 599, 721, 590, 722, 578, 721, 577, 700, 576, 694, 572, 693, 571, 691, 572, 686, 576, 670, 574, 666, 571, 663, 560, 661, 555, 652, 550, 644, 547, 642, 373, 541, 373};
                drawSeperatedPolygon(jojoLegsHand, new Color(5, 5, 30), d);

                // Jojo's Left Jacket + Hand
                Color jojoLightColor = new Color(15, 64, 159);
                Color jojoPreLightColor = new Color(13, 32, 98);
                Color jojoLighterColor = new Color(99, 181, 237);
                Color jojoPreLighterColor = new Color(93, 145, 218);

                int[] jojoLeftJacketHand = {648, 378, 662, 347, 666, 333, 664, 320, 652, 300, 631, 276, 628, 266, 620, 259, 615, 244, 595, 229, 593, 225, 587, 255, 581, 236, 578, 247, 563, 247, 561, 266, 554, 265, 557, 333, 562, 349, 572, 360, 577, 362, 586, 362, 591, 356, 598, 348, 602, 348, 614, 361, 610, 369, 629, 389, 650, 432, 672, 481, 684, 507, 701, 516, 720, 530, 735, 530, 743, 521, 745, 512, 739, 510, 745, 491, 726, 497, 714, 497, 700, 486, 688, 477, 674, 454, 661, 431, 644, 381, 644, 378};
                drawSeperatedPolygon(jojoLeftJacketHand, new Color(5, 5, 30), d);

                int[] topLight = {587, 225, 581, 236, 578, 247, 577, 253, 577, 267, 580, 276, 585, 277, 591, 286, 597, 287, 596, 272, 592, 265, 592, 246, 594, 238, 595, 230};
                drawSeperatedPolygon(topLight, jojoLightColor, d);
                Line[] topLightLines = {makeRightLine(577, 250, 13, 13),
                                        makeRightLine(589, 235, 5, 16)};
                drawLine(topLightLines, new Color(75, 138, 243), d);

                int[] smallLight = {607, 256, 612, 265, 626, 266, 621, 260};
                drawSeperatedPolygon(smallLight, jojoLightColor, d);

                int[] middleLight = {601, 297, 620, 320, 621, 305, 623, 302, 627, 304, 633, 304, 635, 300, 632, 295, 629, 294, 627, 288, 618, 286, 610, 279, 606, 279, 601, 294};
                drawSeperatedPolygon(middleLight, jojoLightColor, jojoPreLightColor, d);

                Line[] jojoJacketLines = {makeRightLine(576, 342, 15, 17),
                                        makeRightLine(570, 331, 14, 15),
                                        makeRightLine(564, 295, 32, 22)};
                drawLine(jojoJacketLines, jojoPreLighterColor, d);

                // Jojo's Chain
                drawChainLoop(572, 250, d);
                drawChainLoop(568, 268, d);
                drawChainLoop(566, 278, d);
                drawChainLoop(568, 290, d);
                drawChainLoop(565, 301, d);

                int[] lowerMiddleLighter = {618, 288, 618, 317, 621, 315, 624, 287};
                drawSeperatedPolygon(lowerMiddleLighter, jojoLighterColor, jojoPreLighterColor, d);
                int[] topMiddleLighter = {601, 297, 609, 290, 612, 283, 607, 280, 603, 288};
                drawSeperatedPolygon(topMiddleLighter, jojoLighterColor, jojoPreLighterColor, d);

                int[] armLight = {612, 364, 613, 367, 617, 370, 623, 370, 634, 345, 640, 342, 641, 324, 635, 317, 634, 315, 629, 317, 624, 342, 615, 359};
                drawSeperatedPolygon(armLight, jojoLightColor, jojoPreLightColor, d);

                int[] armLighter = {612, 364, 613, 367, 616, 369, 624, 356, 634, 327, 633, 320, 629, 317, 624, 342, 615, 359};
                drawSeperatedPolygon(armLighter, jojoLighterColor, jojoPreLighterColor, d);

                // Jojo Left Inside Jacket
                int[] jojoLeftInsideJacket = {560, 340, 562, 349, 572, 360, 577 ,362, 586, 362, 591, 356, 598, 348, 602, 348, 606, 351, 615, 359, 609, 371, 599, 367, 599, 362, 584, 370, 580, 370, 571, 363, 564, 361, 560, 350};
                drawSeperatedPolygon(jojoLeftInsideJacket, new Color(250, 250, 250), d);
                Line[] jojoLeftInsideJacketLines = {makeRightLine(600, 349, 2, 14),
                                                    makeLeftLine(600, 362, 10, 6)};
                drawLines(jojoLeftInsideJacketLines, d);

                // Jojo's Jacket's Flaps
                int[] jojoJacketFlaps = {552, 300, 538, 331, 528, 309, 528, 304, 536, 304, 536, 287, 551, 290, 552, 301};
                drawSeperatedPolygon(jojoJacketFlaps, new Color(232, 227, 234), d);
                d.drawLine(536, 304, 547, 304);

                d.setColor(new Color(52, 14, 71));
                d.fillRectangle(540, 355, 6, 12);
                
                // Jojo's Neck
                int[] jojoNeck = {550, 284, 552, 301, 555, 298, 555, 282};
                drawSeperatedPolygon(jojoNeck, new Color(197, 159, 140), d);

                // Jojo's Top Chest
                int[] jojoTopChest = {538, 331, 538, 353, 556, 327, 556, 298, 552, 301};
                drawSeperatedPolygon(jojoTopChest, new Color(146, 79, 184), new Color(59, 30, 76), d);

                // Jojo's Bottom Chest
                int[] jojoBottomChest = {538, 353, 556, 328, 558, 335, 549, 346, 544, 356, 541, 356};
                drawSeperatedPolygon(jojoBottomChest, new Color(52, 14, 71), new Color(90, 48, 120), d);

                // Jojo's Top Packs
                int[] jojoTopPacks = {544, 356, 542, 373, 544, 392, 549, 406, 560, 410, 562, 414, 564, 393, 573, 385, 580, 379, 586, 375, 592, 373, 598, 371, 599, 362, 584, 370, 579, 370, 571, 363, 564, 361, 560, 350, 558, 335, 549, 346, 544, 356};
                drawSeperatedPolygon(jojoTopPacks, new Color(171, 95, 204), new Color(127, 70, 147), d);

                // Jojo's Lower Packs
                int[] jojoLowerPacks = {561, 351, 553, 360, 548, 371, 549, 388, 554, 396, 560, 403, 563, 403, 564, 386, 563, 381, 562, 376, 564, 361};
                drawSeperatedPolygon(jojoLowerPacks, new Color(131, 64, 161), new Color(89, 37, 112), d);

                // Jojo's Inside Right Jacket
                int[] jojoInsideRightJacket = {538, 330, 536, 331, 535, 406, 537, 409, 549, 417, 552, 418, 557, 436, 564, 463, 564, 446, 561, 442, 562, 437, 559, 433, 563, 418, 560, 410, 548, 406, 544, 392, 542, 374, 541, 356, 538, 352};
                drawSeperatedPolygon(jojoInsideRightJacket, new Color(232, 227, 234), d);

                // Jojo's Belt
                int[] jojoBelt = {603, 368, 596, 370, 576, 381, 566, 394, 564, 398, 560, 411, 563, 419, 569, 415, 572, 404, 580, 393, 586, 385, 596, 378, 604, 377, 607, 373};
                drawSeperatedPolygon(jojoBelt, new Color(251, 240, 151), d);

                Line[] jojoBeltLines = {makeRightLine(562, 400, 6, 16),
                                        makeRightLine(568, 391, 7, 9),
                                        makeRightLine(575, 385, 5, 6),
                                        makeRightLine(580, 380, 8, 5),
                                        makeRightLine(588, 376, 7, 4),
                                        makeRightLine(595, 371, 11, 5)};
                drawLines(jojoBeltLines, d);
                
                // Jojo's Sapphire
                int[] jojoSapphire = {565, 393, 567, 397, 569, 398, 574, 391, 569, 387};
                drawSeperatedPolygon(jojoSapphire, new Color(117, 172, 169), d);

                // Jojo's Ruby
                int[] Jojoruby = {569, 397, 572, 404, 575, 403, 578, 397, 574, 391};
                drawSeperatedPolygon(Jojoruby, new Color(173, 100, 111), d);

                // Jojo's Left Wrist
                int[] jojoLeftWrist = {610, 369, 604, 376, 609, 381, 611, 384, 614, 385, 616, 389, 619, 391, 622, 391, 625, 385, 610, 369};
                drawSeperatedPolygon(jojoLeftWrist, new Color(245, 238, 209), d);

                // Jojo's Inside Cape
                int[] jojoInsideCape = {720, 530, 700, 515, 683, 506, 671, 480, 649, 431, 629, 389, 625, 385, 622, 390, 628, 397, 631, 398, 634, 413, 640, 417, 642, 423, 640, 435, 636, 439, 638, 448, 639, 488, 640, 497, 636, 518, 631, 539, 632, 543, 644, 546, 649, 537, 652, 536, 659, 536, 663, 537, 667, 546, 673, 556, 676, 558, 685, 558, 689, 553, 692, 548, 695, 546, 700, 534, 703, 531, 706, 530,};
                drawSeperatedPolygon(jojoInsideCape, new Color(175, 174, 180), d);

                Line[] jojoInsideCapeLines = {makeRightLine(634, 522, 3, 21),
                                            makeLeftLine(640, 501, 4, 43),
                                            makeLeftLine(641, 464, 20, 67),
                                            makeLeftLine(641, 433, 12, 41),
                                            makeLeftLine(652, 472, 23, 48),
                                            makeLeftLine(652, 472, 28, 48),
                                            makeLeftLine(674, 520, 18, 28),
                                            makeLeftLine(662, 464, 23, 50)};
                drawLines(jojoInsideCapeLines, d);

                // Jojo's Hip
                int[] jojoHip = {589, 436, 583, 452, 580, 551, 587, 566, 594, 572, 606, 573, 610, 569, 611, 559, 610, 554, 610, 551, 615, 553, 619, 550, 615, 542, 615, 539, 619, 539, 611, 528, 608, 516, 609, 454, 608, 440, 605, 436};
                drawSeperatedPolygon(jojoHip, jojoPreLightColor, new Color(5, 5, 30), d);

                int[] jojoHiper = {605, 450, 595, 455, 590, 459, 583, 473, 583, 522, 586, 529, 594, 533, 602, 544, 600, 546, 591, 546, 588, 548, 584, 556, 593, 569, 604, 570, 608, 565, 608, 549, 616, 550, 616, 548, 612, 542, 614, 537, 608, 527, 604, 525, 604, 512, 606, 485, 607, 463};
                drawSeperatedPolygon(jojoHiper, jojoLightColor, jojoPreLightColor, d);

                int[] jojoHipestOne = {596, 463, 593, 500, 594, 506, 596, 507, 599, 506, 602, 480, 601, 463, 599, 462};
                int[] jojoHipestTwo = {581, 525, 581, 549, 583, 553, 585, 552, 589, 545, 599, 545, 600, 544, 600, 542, 598, 539, 585, 531, 583, 526};
                drawSeperatedPolygon(jojoHipestOne, jojoPreLighterColor, jojoLightColor, d);
                drawSeperatedPolygon(jojoHipestTwo, jojoLighterColor, jojoPreLighterColor, d);

                // Jojo's Leg And Hand Lines
                Line[] jojoLegAndHandLines = {makeLeftLine(545, 432, 7, 8),
                                            makeLeftLine(574, 408, 3, 16),
                                            makeRightLine(573, 424, 4, 12),
                                            makeRightLine(587, 396, 30, 35),
                                            makeLeftLine(626, 558, 3, 5),
                                            makeRightLine(650, 573, 12, 12),
                                            makeRightLine(685, 579, 16, 13)};
                drawLine(jojoLegAndHandLines, jojoLightColor, d);

                // Jojo's Palm
                int[] jojoPalm = {551, 528, 558, 555, 560, 566, 568, 567, 571, 564, 572, 563, 573, 554, 572, 550, 571, 547, 569, 546, 569, 535, 567, 533, 566, 530, 562, 527};
                drawSeperatedPolygon(jojoPalm, new Color(229, 218, 200), d);

                Line[] jojoPalmLines = {makeLeftLine(560, 530, 4, 11),
                                        makeRightLine(563, 540, 1, 10),
                                        makeRightLine(563, 548, 5, 2),
                                        makeLeftLine(563, 550, 8, 11),
                                        makeLeftLine(559, 551, 5, 13),
                                        makeLeftLine(563, 563, 5, 3),
                                        makeLeftLine(567, 548, 6, 8)};
                drawLines(jojoPalmLines, d);
            }

            private static void drawLines(Line[] lines, DrawSurface d) {
                drawLine(lines, Color.BLACK, d);
            }

            private static void drawLine(Line[] lines, Color c, DrawSurface d) {
                d.setColor(c);
                for (Line line : lines) {
                    int sX = (int) line.start().getX();
                    int sY = (int) line.start().getY();
                    int eX = (int) line.end().getX();
                    int eY = (int) line.end().getY();
                    d.drawLine(sX, sY, eX, eY);
                }
            }

            private static void drawPolygon(int[] x, int[] y, Color c, DrawSurface d) {
                Polygon polygon = new Polygon(x, y, x.length);
                d.setColor(c);
                d.fillPolygon(polygon);
                d.setColor(Color.BLACK);
                d.drawPolygon(polygon);
            }

            private static void drawPolygon(int[] x, int[] y, Color cIn, Color cOut, DrawSurface d) {
                Polygon polygon = new Polygon(x, y, x.length);
                d.setColor(cIn);
                d.fillPolygon(polygon);
                d.setColor(cOut);
                d.drawPolygon(polygon);
            }

            private static int[][] seperateArray(int[] oneArray) {
                int[][] twoArray = new int[2][oneArray.length / 2];
                for (int i = 0; i < oneArray.length; i++) {
                    switch (i % 2) {
                        case (0) :
                            twoArray[0][i / 2] = oneArray[i];
                            break;
                        case (1) :
                            twoArray[1][i / 2] = oneArray[i];
                            break;
                    }
                }
                return twoArray;
            }

            private static void drawSeperatedPolygon(int[] arr, Color c, DrawSurface d) {
                int[][] twoArray = seperateArray(arr);
                int[] xArray = twoArray[0];
                int[] yArray = twoArray[1];
                drawPolygon(xArray, yArray, c, d);
            }

            private static void drawSeperatedPolygon(int[] arr, Color cIn, Color cOut, DrawSurface d) {
                int[][] twoArray = seperateArray(arr);
                int[] xArray = twoArray[0];
                int[] yArray = twoArray[1];
                drawPolygon(xArray, yArray, cIn, cOut, d);
            }

            private static Line makeLeftLine(int x, int y, int width, int height) {
                height--;
                width--;
                return new Line(x, y , x + width, y + height);
            }

            private static Line makeRightLine(int x, int y, int width, int height) {
                height--;
                width--;
                return new Line(x, y + height , x + width, y);
            }

            private static void drawChainLoop(int x, int y, DrawSurface d) {
                Color chainColor = new Color(217, 217, 153);
                Color chainOuterColor = chainColor.darker();
                int width = 11, height = 23;

                d.setColor(chainOuterColor);
                d.fillOval(x - 1, y - 1, width + 2, height + 2);
                d.setColor(chainColor);
                d.fillOval(x, y, width, height);
                d.setColor(new Color(5, 5, 30));
                d.fillOval(x + 2, y + 4, width - 4, height - 8);
                d.setColor(chainOuterColor);
                d.drawOval(x + 2, y + 4, width - 4, height - 8);
            }

            @Override
            public void timePassed(DrawSurface d) {
                for (int i = 1; i < JojoApprochesDio.moveableBlockGroups.size() + 1; i++) {
                    MoveableBlockGroup moveableBlockGroup = new MoveableBlockGroup(JojoApprochesDio.moveableBlockGroups.get(i - 1).blocks);
                    long time = System.nanoTime() / 100000000;
                    moveableBlockGroup.changeAllSpeed(Math.sin(time) * (i + 1) / i / 2, Math.cos(time) * (i - 1) / i);
                }
            }

            @Override
            public void addToGame(GameLevel g) {
                g.addSprite(this);
            }
            
        };
    }

    @Override
    public List<Block> blocks() {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.addAll(createBlockPattern(40, 75));
        blocks.addAll(createBlockPattern(180, 100));
        blocks.addAll(createBlockPattern(320, 150));
        blocks.addAll(createBlockPattern(500, 90));
        blocks.addAll(createBlockPattern(650, 60));

        return blocks;
    }

    private static List<MoveableBlock> createBlockPattern(int x, int y) {
        Rectangle mainRect = new Rectangle(new Point(x, y), 18, 197);
        Rectangle horizontalRect = new Rectangle(new Point(x + 17, y + 121), 91, 27);
        Rectangle longRect = new Rectangle(new Point(x + 31, y+ 2), 21, 106);
        Rectangle shortRect = new Rectangle(new Point(x + 60, y + 7), 19, 88);

        ArrayList<MoveableBlock> blocks = new ArrayList<>();
        blocks.add(new MoveableBlock(mainRect, Color.BLUE));
        blocks.add(new MoveableBlock(horizontalRect, Color.BLUE));
        blocks.add(new MoveableBlock(longRect, Color.BLUE));
        blocks.add(new MoveableBlock(shortRect, Color.BLUE));
        MoveableBlockGroup group = new MoveableBlockGroup(blocks);
        moveableBlockGroups.add(group);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
    
}
