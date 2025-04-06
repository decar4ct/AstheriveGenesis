fracture = new ItemTurret("fracture"){{
            requirements(Category.turret, with(ElarisItems.quartz, 50, ElarisItems.magnetite, 40));
            researchCost = with(ElarisItems.quartz, 100, ElarisItems.magnetite, 75);
  
            health = 700;
            outlineColor = AGPal.outline;
            reload = 80f;
            inaccuracy = 2f;
            size = 3;
            recoil = 3f;
            range = 18 * Vars.tilesize;
            rotateSpeed = 3f;
            squareSprite = false;
            shootSound = Sounds.cannon;
  
            drawer = new DrawTurret("elaris-"){{
                parts.add(
                        new RegionPart("-side"){{
                            progress = PartProgress.warmup;
                            mirror = true;
                            under = false;
                            moveRot = -10;
                        }},
            }};
        }};
