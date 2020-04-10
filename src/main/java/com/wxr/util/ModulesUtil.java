package com.wxr.util;

import com.wxr.entity.Modules;
import com.wxr.entity.ModulesDto;

public class ModulesUtil {

	public static ModulesDto getModuleDtoByModule(Modules module) {
		ModulesDto modulesDto = new ModulesDto(module.getId(), module.getName(), module.getParentId(),
				module.getPath() == null ? "" : module.getPath(), module.getOps() == null ? "" : module.getOps(),
				module.getWeight() == null ? 0 : module.getWeight(), module.getInt0() == null ? 0 : module.getInt0(),
				0, "");
		return modulesDto;
	}
}
